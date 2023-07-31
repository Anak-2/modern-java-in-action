package study.javalang.ch05;

import study.javalang.ch04.Dish;

import javax.swing.*;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static study.javalang.ch04.Dish.menu;

public class MatchingTest {
    public static void main(String[] args) throws InterruptedException{

        long startTime = System.nanoTime();
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("Menu Contains Vegetarian");
        }
        System.out.println((System.nanoTime() - startTime) + "ns");

        long startTime2 = System.nanoTime();
        for (Dish dish : menu) {
            if(dish.isVegetarian()) {
                System.out.println("Menu Contains Vegetarian");
                break;
            }
        }
        System.out.println((System.nanoTime() - startTime2) + "ns");


        if(menu.stream().allMatch(d -> d.getCalories() > 100)){
            System.out.println("All menu is over 100 Cal");
        }else{
            System.out.println("Some menu is less than 100 Cal");
        }

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));
    }
}
