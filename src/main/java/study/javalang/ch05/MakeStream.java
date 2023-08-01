package study.javalang.ch05;

import java.util.stream.Stream;

public class MakeStream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        printFibonacci();
        generateRandom(10);
    }

    public static void printFibonacci(){
        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("t[0]: "+t[0]+" t[1]: "+t[1]));
    }

    public static void generateRandom(int n){
        Stream.generate(Math::random)
                .limit(n)
                .forEach(System.out::println);
    }
}
