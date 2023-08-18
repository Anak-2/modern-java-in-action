package study.javalang.ch09.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subjects {

    private final List<Observer> observers = new ArrayList<>();

    public void registersObserver(Observer o){
        observers.add(o);
    }
    public void notifyObservers(String tweet){
        observers.forEach(o -> o.notify(tweet));
    }
}
