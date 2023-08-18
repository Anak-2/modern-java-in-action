package study.javalang.ch09.patterns.templatemethod.onlinebanking;

import lombok.Getter;

@Getter
public class Customer {

    private final int id;
    private final String name;
    private final String account;

    public Customer(final int id, final String name, final String account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }
}
