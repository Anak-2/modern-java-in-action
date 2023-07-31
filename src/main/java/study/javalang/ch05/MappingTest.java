package study.javalang.ch05;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

public class MappingTest {
    public static void main(String[] args){

//        모든 순열 조합
        Integer[] ints1 = new Integer[]{1,2,3};
        Integer[] ints2 = new Integer[]{4,5};
        List<Integer[]> integerList = Arrays.stream(ints1)
                .flatMap(i -> Arrays.stream(ints2).map(j -> new Integer[]{i,j}))
                .toList();
        integerList.forEach(i -> System.out.print(Arrays.toString(i)));

//        순열 조합 중에서 합이 3으로 나눠 떨어지는 배열
        List<Integer[]> modIntegerList = integerList.stream()
                .filter((arr) -> (arr[0] + arr[1]) % 3 == 0)
                .toList();

        modIntegerList.forEach(i -> System.out.print(Arrays.toString(i)));
    }
}
