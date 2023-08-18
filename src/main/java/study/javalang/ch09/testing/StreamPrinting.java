package study.javalang.ch09.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamPrinting {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,3,4,5);

        numbers.stream()
                .peek(x -> System.out.println("from first stream: "+x))
                .map(x -> x+17)
                .peek(x -> System.out.println("from second stream: "+x))
                .filter(x -> x%2 == 0)
                .peek(x -> System.out.println("from third stream: "+x))
                .forEach(System.out::println);

    }
}
