package study.javalang.ch05;

import study.javalang.ch04.Dish;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static study.javalang.ch04.Dish.menu;

// 기본형 특화 스트림 (Primitive Stream Specialization)
public class PrimitiveStream {

    public static void main(String[] args) {
        System.out.println("calories sum :"+caloriesSum());
        System.out.println(backToStream());
    }

//    int stream
    public static int caloriesSum(){
        int caloriesSum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        return caloriesSum;
    }

    public static Class<?> backToStream(){
        IntStream integerStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = integerStream.boxed();
        return stream.getClass();
    }
}
