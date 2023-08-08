package study.javalang.ch06;

import study.javalang.ch04.Dish;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static study.javalang.ch04.Dish.menu;

public class CustomToList {

    public static void main(String[] args) {

        List<Dish> dishes = menu.stream().collect(new ToListCollector<Dish>());
        System.out.println(dishes);

        System.out.println(partitionPrimesWithCustomCollector(10));
    }
    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n){
        return IntStream.rangeClosed(2,n).boxed()
                .collect(new PrimeNumbersCollector());
    }

    public static class ToListCollector<T> implements Collector<T, List<T>, List<T>>{

        @Override
        public Supplier<List<T>> supplier(){
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<T>, T> accumulator(){
            return List::add;
        }

        @Override
        public Function<List<T>, List<T>> finisher(){
            return Function.identity();
        }


        @Override
        public BinaryOperator<List<T>> combiner(){
            return (list1, list2) -> {
                list1.addAll(list2);
                return list1;
            };
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(
                    Characteristics.IDENTITY_FINISH, CONCURRENT
            ));
        }
    }

    public static boolean isPrime(List<Integer> primes, int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>>{

        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() { // supply instance
            return () -> new HashMap<Boolean, List<Integer>>(){{
                put(true, new ArrayList<Integer>());
                put(false, new ArrayList<Integer>());
            }};
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() { // core function to decide partition
            return (Map<Boolean, List<Integer>> acc, Integer candidate) ->{
                acc.get(isPrime(acc.get(true), candidate)) // check if candidate is divided by prime num
                        .add(candidate); // accumulate
            };
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() { // combine results
            return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
            };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
        }
    }
}
