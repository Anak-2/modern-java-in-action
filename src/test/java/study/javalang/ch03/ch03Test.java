package study.javalang.ch03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
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
                Assertions.assertEquals(a,b);
            }
        );


    }
}
