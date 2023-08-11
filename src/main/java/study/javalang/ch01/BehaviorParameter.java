package study.javalang.ch01;

import java.util.*;
import java.util.stream.IntStream;

public class BehaviorParameter {

    public static void main(String[] args) {
        Integer[] list = IntStream.rangeClosed(1,10).boxed().toArray(Integer[]::new);
        Arrays.sort(list, (a, b) -> {
            return a - b;
        });
    }

}
