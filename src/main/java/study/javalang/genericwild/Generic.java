package study.javalang.genericwild;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Generic {

    public static void main(String[] args) {
        Generic g = new Generic();
        g.printGeneric(new MyChild());
        g.printGeneric(new MyParent());
//        g.printGeneric(new MyGrandParent()); --> MyParent 로 상한선 설정했으므로 오류
        printWild(Arrays.asList(new MyChild()));
        printWild(Arrays.asList(new MyParent()));
//        printWild(Arrays.asList(new MyGrandParent())); --> MyParent 로 상한선 설정했으므로 오류
    }

//    Generic 의 extends -> 상한선 설정(매개변수로 T의 서브 타입만 올 수 있음)
    <T extends MyParent> void printGeneric(T t){
        System.out.println("Generic Class: "+t.getClass());
        t.printInfo();
    }

//    WildCard 의 extends -> 상한선 설정(매개변수로 ?의 서브 타입만 올 수 있음)
    static void printWild(Collection<? extends MyParent> c){
//        c.stream().forEach(MyChild::printInfo); --> ? 는 현재 MyParent 를 상속 받았으므로 그 서브타입까지 알 수 없음!
        c.stream().forEach(e -> {
            System.out.println("Wild Card Class: "+e.getClass());
            e.printInfo();
//            e.printChild(); --> 위에 MyChild::printInfo 와 같은 이유로 오류!
            e.printParent();
            e.printGrandParent();
        });
    }
}

class MyChild extends MyParent{

    @Override
    public void printInfo(){
        System.out.println("MyChild");
    }

    public void printChild(){
        System.out.println("I'm a Child");
    }
}


class MyParent extends MyGrandParent{

    @Override
    public void printInfo(){
        System.out.println("MyParent");
    }

    public void printParent(){
        System.out.println("I'm a Parent");
    }
}

class MyGrandParent{

    public void printInfo(){
        System.out.println("MyGrandParent");
    }

    public void printGrandParent(){
        System.out.println("I'm a GrandParent");
    }
}

class Family<T extends MyParent>{

}