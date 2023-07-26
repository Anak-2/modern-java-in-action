package study.javalang.ch01;

public class Apple {

    private AppleColor color;

    public AppleColor getColor() {
        return color;
    }

    public enum AppleColor{
        GREEN, RED, YELLOW;
    }


    public boolean isGreen(){
        return (getColor() == AppleColor.GREEN);
    }
}
