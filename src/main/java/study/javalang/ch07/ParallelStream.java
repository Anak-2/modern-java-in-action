package study.javalang.ch07;

import java.util.function.Function;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        getPerformance(ParallelStream::parallelSum, ParallelStream::iterateSum);
    }

    public static long iterateSum(long n){
        long sum = 0;
        for(long i = 1L; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L,i -> i+1)
                .limit(n)
                .parallel() // make stream parallel
                .reduce(0L, Long::sum);
    }

    public static void getPerformance(Function<Long, Long> func1, Function<Long, Long> func2){
        long start = System.currentTimeMillis();
        func1.apply(1000000L);
        long finish1 = System.currentTimeMillis() - start;
        System.out.println("finish1: "+finish1+"ms");
        start = System.currentTimeMillis();
        func2.apply(1000000L);
        long finish2 = System.currentTimeMillis() - start;
        System.out.println("finish2: "+finish2+"ms");

        System.out.println("difference between func1 and func2: "+(finish1 - finish2)+"ms");
    }
}
