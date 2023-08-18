package study.javalang.ch09.patterns.strategy;

import java.util.function.Predicate;

public class StrategyPattern {

    public interface ValidationStrategy{
        boolean execute(String s);
    }

    public class Validator{
        private final Predicate p;

        public <T> Validator(Predicate<T> p){
            this.p = p;
        }

        public boolean validate(String s){
            return p.test(s);
        }
    }
}
