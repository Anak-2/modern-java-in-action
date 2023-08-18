package study.javalang.ch09;

import java.util.logging.Logger;

public class Refactoring {

//    Anonymous Class to Lambda Expression
    static class AnoToLambda {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Runnable r2 = () -> {
            System.out.println("Hello");
        };

        int a = 10;

        Runnable r3 = () -> {
            int a = 20;
            System.out.println(a);
        };

    }

    public static void main(String[] args) {
        AnoToLambda anoToLambda = new AnoToLambda();
        anoToLambda.r3.run();

        int a = 10;

        Runnable r4 = () -> {
//            int a = 20; -> Compile Error! 이미 지정된 변수
            System.out.println(a);
        };

//        r5 에선 r4 문제 발생 x
        Runnable r5 = new Runnable() {
            @Override
            public void run() {
                int a = 20;
                System.out.println(a);
            }
        };


    }
}
