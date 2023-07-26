package study.javalang;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import study.javalang.ch01.Pizza;
import study.javalang.ch01.PizzaStore;

@SpringBootTest
class JavalangApplicationTests {

	@Test
	void contextLoads() {
	}

    @DisplayName("Pizza 주문")
    @Test
    void pizzaOrder(){
        PizzaStore pizzaStore = new PizzaStore();
        pizzaStore.pizzaOrder(Pizza.LARGE);
    }
}
