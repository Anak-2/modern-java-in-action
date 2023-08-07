package study.javalang.ch06;

import study.javalang.ch04.Dish;

import static java.util.stream.Collectors.*;
import static study.javalang.ch04.Dish.menu;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {

//        get dishes grouped by dish type
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

        System.out.println(dishesByType);

//        classify by calorie
        Map<CaloricLevel, List<Dish>> dishesByCalorie = menu.stream().collect(groupingBy(dish -> {
            if(dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));

        System.out.println("dishesByCalorie: "+dishesByCalorie);

//        classify by dish type and calorie
        Map<Dish.Type, List<Dish>> dishesByCalorieAndType = menu.stream().collect(groupingBy(Dish::getType, filtering(dish->
                dish.getCalories() > 500, toList())));

        System.out.println("dishesByCalorieAndType: "+dishesByCalorieAndType);

//        classifying multilevel
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesBytMultilevel = menu.stream().collect(groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })));

        System.out.println("dishesByMultilevel: "+dishesBytMultilevel);

        Map<Dish.Type, Optional<Dish>> maxCalorieByType = menu.stream().collect(groupingBy(Dish::getType,
                maxBy((d1, d2) -> d1.getCalories() - d2.getCalories())));

        System.out.println("maxCalorieByType: "+maxCalorieByType);
    }

//    get max calorie of each dish type

    public enum CaloricLevel { DIET, NORMAL, FAT }
}
