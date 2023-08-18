package study.javalang.ch09.patterns.chainresponse;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponse {

    public static void main(String[] args) {

        UnaryOperator<String> headerProcessing =
                (String input) -> "From Raoul, Mario and Alan "+input;
        UnaryOperator<String> spellCheckProcessing =
                (String input) -> input.replaceAll("labda","lambda");
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckProcessing);

        String result = pipeline.apply("Aren't labdas really sexy?!");
        System.out.println(result);


        MyInterface m = (String name) -> System.out.println("Hello "+name);
        MyInterface m2 = new MyInterface() {
            @Override
            public void greeting(String name) {
                System.out.println("Hello "+name);
            }
        };
    }

}
