package study.javalang.ch09.patterns.strategy;

public class DesignPattern {

    public static void main(String[] args) {

        // Strategy Pattern
        StrategyPattern st = new StrategyPattern();
        StrategyPattern.Validator isLowerCase = st.new Validator((String s) -> {{return s.matches("[a-z]+");}});
        StrategyPattern.Validator isNumeric = st.new Validator((String s) -> {{return s.matches("\\d+");}});


    }


}
