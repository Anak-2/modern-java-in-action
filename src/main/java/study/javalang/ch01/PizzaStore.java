package study.javalang.ch01;

public class PizzaStore {
    public void pizzaOrder(Pizza pizza){
        switch (pizza) {
            case LARGE -> System.out.println("라지 피자: " + pizza.getPizzaSize());
            case MEDIUM -> System.out.println("미디엄 피자: " + pizza.getPizzaSize());
            case SMALL -> System.out.println("스몰 피자: " + pizza.getPizzaSize());
        }
    }
}
