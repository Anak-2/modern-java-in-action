package study.javalang.ch03;

import java.util.ArrayList;
import java.util.*;

public class MethodReferencePractice {

    FunctionalInterface functionalInterface;

    public MethodReferencePractice(FunctionalInterface functionalInterface){
        this.functionalInterface = functionalInterface;
    }

    public String printString(String sentence){
        return functionalInterface.printString(sentence);
    }

}


