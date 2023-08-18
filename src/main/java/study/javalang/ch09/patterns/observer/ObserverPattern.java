package study.javalang.ch09.patterns.observer;

public class ObserverPattern {

    public static void main(String[] args) {
        Subjects subjects = new Subjects();

//        ObserverImpl oi = new ObserverImpl();
//        subjects.registersObserver(oi.new Guardian());
//        subjects.registersObserver(oi.new LeMonde());
//        subjects.registersObserver(oi.new NYTimes());

        subjects.registersObserver((String tweet) -> {
            System.out.println("Breaking news in LM! " + tweet);
        });
        subjects.registersObserver((String tweet) -> {
            System.out.println("Breaking news in GD! " + tweet);
        });
        subjects.registersObserver((String tweet) -> {
            System.out.println("Breaking news in NY! " + tweet);
        });

        subjects.notifyObservers("show me the money!");
    }
}
