package study.javalang.ch09.patterns.factory;

import lombok.Getter;
import study.javalang.ch09.patterns.chainresponse.ProcessingObject;

public class Product {

    private String name;

    public void setName(String name){
        this.name = name;
    }
}
