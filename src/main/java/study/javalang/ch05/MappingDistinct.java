package study.javalang.ch05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MappingDistinct {

    public static void main(String[] args){

        List<String> helloWorld = Arrays.asList("Hello","World");
        List<String[]> mappedResult = mappingDistinctAlphabet1(helloWorld);
        mappedResult.forEach(s -> System.out.println(Arrays.toString(s)));

        List<String> mappedResult2 = mappingDistinctAlphabet2(helloWorld);
        mappedResult2.forEach(System.out::println);
    }

    // String[] 으로 반환하기 때문에 distinct() 메서드가 원하는 대로 안 먹힘
    public static List<String[]> mappingDistinctAlphabet1(List<String> sentence){
        return sentence.stream()
                .map(words -> words.split(""))
                .toList();
    }

    // flatMap + Arrays.stream() 으로 Stream<String[]> 을 Stream<String> 으로 변환 후 distinct 사용하기
    public static List<String> mappingDistinctAlphabet2(List<String> sentence){
        return sentence.stream()
                .map(words -> words.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
    }
}
