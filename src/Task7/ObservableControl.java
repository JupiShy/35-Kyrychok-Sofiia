package Task7;

import java.util.ArrayList;
import java.util.List;
import Task3.View;

/**
 *
 * @author megas
 */
public class ObservableControl implements Observable {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(View view) {
        for (Observer observer : observers) {
            observer.update(view);
        }
    }

}
