package observer;

import java.util.ArrayList;
import java.util.List;

/** Subject: tells every attached observer what happened. */
public class Subject {

    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(ReservationEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}