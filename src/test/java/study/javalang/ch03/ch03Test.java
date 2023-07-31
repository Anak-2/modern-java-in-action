package study.javalang.ch03;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.javalang.ch02.Apple;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class ch03Test {

    @DisplayName("ForEach Test")
    @Test
    void forEachTest(){
        LambdaPractice lambdaPractice = new LambdaPractice();
        lambdaPractice.tryForEach();
    }

    @DisplayName("Functional Test")
    @Test
    void functionalTest(){
        // given
        LambdaPractice lambdaPractice = new LambdaPractice();
        List<String> inputList = Arrays.asList("hello","my","world");
        //when
        List<Integer> lengthList = lambdaPractice.map(inputList, (s) -> s.length());
        //then
        List<Integer> compareList = Arrays.asList(5,2,5);
        IntStream.range(0, inputList.size()).forEach(i ->{
                int a = lengthList.get(i);
                int b = compareList.get(i);
                assertEquals(a,b);
            }
        );


    }

    @DisplayName("MethodReference Test")
    @Test
    void refTest(){
        MethodReferencePractice methodReferencePractice = new MethodReferencePractice((s) -> {
            System.out.println(s);
            return s;
        });
        Function<String, String> printFunc = methodReferencePractice::printString;
        assertEquals("Hello World",printFunc.apply("Hello World"));
    }

    @DisplayName("Sort with Method Reference")
    @Test
    void composeTest(){
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
    }

    @DisplayName("Calculate Test")
    @Test
    void calTest(){
        BiFunction<Integer, Integer, Integer> addRef = Calculate::add;
        assertEquals(10, addRef.apply(5,5));
    }

}
