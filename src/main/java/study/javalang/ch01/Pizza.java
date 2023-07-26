package study.javalang.ch01;

public enum Pizza {
    LARGE(30), MEDIUM(20), SMALL(10);

    private final int size;

    private Pizza(int size){
        this.size = size;
    }

    public int getPizzaSize(){
        return size;
    }
}
