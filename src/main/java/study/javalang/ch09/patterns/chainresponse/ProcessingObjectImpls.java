package study.javalang.ch09.patterns.chainresponse;

public class ProcessingObjectImpls {

    public class HeaderTextProcessing extends ProcessingObject<String>{
        @Override
        protected String handleWork(String input) {
            return "From Raoul, Mario and Alan "+input;
        }
    }

    public class SpellCheckerProcessing extends ProcessingObject<String>{
        @Override
        protected String handleWork(String input) {
            return input.replaceAll("labda","lambda");
        }
    }
}
