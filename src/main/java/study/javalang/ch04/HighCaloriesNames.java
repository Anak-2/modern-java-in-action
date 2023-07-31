package study.javalang.ch04;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static study.javalang.ch04.Dish.menu;

public class HighCaloriesNames {

    public static void main(String[] args){
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering "+dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(Dish::getName)
                .limit(3)
                .toList();

        names.forEach(System.out::println);
    }
}
