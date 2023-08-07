package study.javalang.ch06;

import study.javalang.ch04.Dish;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static study.javalang.ch04.Dish.menu;

public class PredefinedCollector {
    public static void main(String[] args) {

//        get menu count
        long menuCount = menu.stream().collect(Collectors.counting());
        long menuCount2 = menu.stream().count();

        System.out.println("menuCount: "+menuCount);
        System.out.println("menuCount2: "+menuCount2);

//        get max calorie menu
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> maxCalorie = menu.stream().collect(maxBy(dishComparator));
        Optional<Dish> maxCalorie2 = menu.stream().max(dishComparator);

        System.out.println("maxCalorie: "+maxCalorie.orElse(null));
        System.out.println("maxCalorie2: "+maxCalorie2.orElse(null));

//        get total calories
        long totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        long totalCalories2 = menu.stream().collect(summingInt(Dish::getCalories));

        System.out.println("total cal: "+totalCalories);

//        get avg calories
        double averageInt = menu.stream().collect(averagingInt(Dish::getCalories));

        System.out.println("avg cal:"+averageInt);

//        get summary of statistics (count, sum, min, avg, max)
        printSummary(menu,Dish::getCalories);

//        joining method
        printJoining(menu,Dish::getName);
    }

    public static<T> void printSummary(List<T> list, ToIntFunction<T> intFunction){
        IntSummaryStatistics menuStatistics = list.stream().collect(summarizingInt(intFunction));
        System.out.println("menu statistics: "+menuStatistics);
    }

    public static<T,R extends String> void printJoining(List<T> list, Function<T, R> mapper){
        String joined = list.stream().map(mapper).collect(joining(", "));
        System.out.println(joined);
    }

}
