package study.javalang.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.javalang.ch02.printapple.PrintApple;
import study.javalang.ch02.printapple.PrintAppleInfo;

public class AppleTest {

    @DisplayName("Print Apple 메서드 테스트")
    @Test
    void printApple(){
        //given
        Apple apple = Apple.createApple(Apple.AppleColor.RED, 150);
        AppleFormatter appleFormatter = new AppleFormatter();
        PrintAppleInfo printAppleInfo = new PrintAppleInfo();
        //then
        appleFormatter.printAppleInfo( printAppleInfo, apple);
    }
}
