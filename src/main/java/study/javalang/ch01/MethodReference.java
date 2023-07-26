package study.javalang.ch01;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import static ch01.Apple.AppleColor.GREEN;

public class MethodReference {
    public void main(){

        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

//        메서드 참조를 이용해 isHidden 을 일급 객체처럼 동적 파라미터 전달
        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);
    }


//    사과들 중 초록색 사과를 고르는 함수
    public List<Apple> getGreenApples(List<Apple> appleList){
        List<Apple> greenApples = new ArrayList<>();

        for(Apple apple : appleList){
            if(apple.isGreen()){
                greenApples.add(apple);
            }
        }

        return greenApples;
    }


}
