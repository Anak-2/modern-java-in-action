package study.javalang.ch09.patterns.templatemethod;

import study.javalang.ch09.patterns.templatemethod.onlinebanking.Customer;
import study.javalang.ch09.patterns.templatemethod.onlinebanking.OnlineBanking;

public class TemplateMethod {


    public static void main(String[] args) {

        OnlineBanking ob = new OnlineBanking();
        ob.processCustomerV2(12,(Customer c) -> System.out.println("Hello "+c.getName()+"!"));

    }
}
