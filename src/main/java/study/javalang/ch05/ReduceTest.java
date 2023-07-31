package study.javalang.ch05;

import study.javalang.ch04.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static study.javalang.ch04.Dish.menu;

public class ReduceTest {
    public static void main(String[] args){
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(getSum(integers));
        System.out.println(getMax(integers));
        System.out.println(getDish(menu));
    }

    public static int getSum(List<Integer> integers){
        return integers.stream().reduce(0, Integer::sum);
    }

    public static int getMax(List<Integer> integers){
        return integers.stream().reduce(0,Integer::max);
    }

    public static int getDish(List<Dish> dishes){
        return dishes.stream()
                .map(Dish::getName)
                .distinct()
                .map((d) -> 1)
                .reduce(0, (a,b) -> a+b);
    }
}
