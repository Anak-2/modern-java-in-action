package study.javalang.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaPractice {

        FunctionalInterface functionalInterface = (s) -> {
            System.out.println(s);
            return s;
        };

    void printSentence(String sentence){
        functionalInterface.printString(sentence);
    }

    // Consumer Example
    public <T> void forEach(List<T> list, Consumer<T> consumer){
        for(T t : list){
            consumer.accept(t);
        }
    }

    public void tryForEach(){
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        forEach(integerList, (a) -> System.out.println(a));
    }

    // Function Example (T를 받아서 R을 반환)
    public <T, R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(f.apply(t));
        }
        return result;
    }

}
