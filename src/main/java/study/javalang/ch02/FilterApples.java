package study.javalang.ch02;

import study.javalang.ch02.applepredicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class FilterApples {

    private List<Apple> appleFiltered = new ArrayList<>();

    public FilterApples(List<Apple> appleList){
        for(Apple apple : appleList){
            this.appleFiltered.add(new Apple(apple));
        }
    }
//    filter 기능을 "동작 파라미터화" 해서 다양한 요구사항에 대처할 수 있도록 설계 (ApplePredicate를 추상화 함으로써 "전략 디자인 패턴")
    public List<Apple> filter(List<Apple> appleList, ApplePredicate applePredicate){

        for(Apple apple : appleList){
            if(applePredicate.test(apple)) this.appleFiltered.add(apple);
        }

        return this.appleFiltered;
    }

}
