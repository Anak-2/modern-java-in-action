package study.javalang.ch01;

import lombok.Getter;

@Getter
public class Apple {

    private AppleColor color;

    public enum AppleColor{
        GREEN, RED, YELLOW;
    }

    public Apple(AppleColor appleColor){
        this.color = appleColor;
    }

    public boolean isGreen(){
        return this.getColor().equals(AppleColor.GREEN);
    }
}
