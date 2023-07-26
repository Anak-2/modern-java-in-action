package study.javalang.ch02;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Apple {

    private int weight;

    private AppleColor color;

    public enum AppleColor {
        GREEN, RED, YELLOW;
    }

    public Apple(Apple apple){
        this.color = apple.getColor();
        this.weight = apple.getWeight();
    }

    @Builder
    public static Apple createApple(AppleColor appleColor, int weight){
        return new Apple(weight, appleColor);
    }

    public boolean isGreen() {
        return this.getColor().equals(AppleColor.GREEN);
    }


}
