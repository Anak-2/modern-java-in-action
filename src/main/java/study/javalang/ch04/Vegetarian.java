package study.javalang.ch04;

import java.util.List;
import java.util.stream.Collectors;

import static study.javalang.ch04.Dish.menu;


public class Vegetarian {
    public static void main(String[] args){
        List<Dish> vegetarianList = menu.stream()
                .filter(Dish::isVegetarian)
                .toList();
        vegetarianList.forEach(System.out::println);
    }
}
