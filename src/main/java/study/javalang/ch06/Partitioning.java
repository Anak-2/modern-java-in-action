package study.javalang.ch06;

import study.javalang.ch04.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
import static study.javalang.ch04.Dish.menu;


public class Partitioning {
    public static void main(String[] args) {

//        partition according to vegetarian
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));

        System.out.println("partitionedMenu: "+partitionedMenu);

//        high level partition
        Map<Boolean, Map<Dish.Type, List<Dish>>> partitionedMenu2 = menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println("partitionedMenu2: "+partitionedMenu2);

//        partition according to vegetarian and 500 cal baseline
        Map<Boolean, Map<Boolean, List<Dish>>> partitionedMenuWithCal = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                partitioningBy((dish) -> {return dish.getCalories() > 500;})));

        System.out.println("partitionedMenuWithCal: "+partitionedMenuWithCal);

//        partition by prime
        List<Integer> num = IntStream.range(2,100).boxed().toList();
        Partitioning p = new Partitioning();
        Map<Boolean, List<Integer>> primeNum = num.stream().collect(partitioningBy(p::isPrime));

        System.out.println("primeNum: "+primeNum);
    }

    public boolean isPrime(int num){
        return IntStream.range(2, num)
                .noneMatch(i -> num % i == 0);
    }
}
