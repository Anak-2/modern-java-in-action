package study.javalang.ch02.applepredicate;

import study.javalang.ch02.Apple;

public class AppleGreenPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.isGreen();
    }
}
