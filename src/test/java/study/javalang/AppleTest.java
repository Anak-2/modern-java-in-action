package study.javalang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.javalang.ch01.Apple;
import study.javalang.ch01.MethodReference;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AppleTest {

    @DisplayName("초록색 사과 필터 테스트")
    @Test
    void filterGreen(){
        //given
        List<Apple> appleList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if (i%2 == 0) appleList.add(new Apple(Apple.AppleColor.GREEN));
            else appleList.add(new Apple(Apple.AppleColor.RED));
        }
        MethodReference methodReference = new MethodReference();
        //when
        List<Apple> greenApplesV1 = methodReference.getGreenApplesV1(appleList);
        List<Apple> greenApplesV2 = methodReference.getGreenApplesV2(appleList, Apple::isGreen);
        //then
        Assertions.assertEquals(greenApplesV1.size(), 5);
        Assertions.assertEquals(greenApplesV2.size(), 5);
    }
}
