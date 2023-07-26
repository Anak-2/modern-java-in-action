package study.javalang.ch02.printapple;

import study.javalang.ch02.Apple;

public class PrintAppleInfo implements PrintApple{
    @Override
    public void printApple(Apple apple) {
        System.out.println("Apple Color: "+apple.getColor()+"\nApple Weight: "+apple.getWeight());
    }
}
