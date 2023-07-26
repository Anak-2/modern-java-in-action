package study.javalang.ch02.printapple;

import study.javalang.ch02.Apple;

public class PrintAppleColor implements PrintApple{
    @Override
    public void printApple(Apple apple) {
        System.out.println("Apple Color: "+apple.getColor());
    }
}
