package study.javalang.ch09.patterns.templatemethod.onlinebanking;

import java.util.function.Consumer;

public class OnlineBanking {

    public void processCustomerV2(int id, Consumer<Customer> makeCustomerHappy){
        Customer c = getCustomer(id);
        makeCustomerHappy.accept(c);
    }

    public Customer getCustomer(int id){
        return new Customer(id, "kim", "123-456");
    }
}
