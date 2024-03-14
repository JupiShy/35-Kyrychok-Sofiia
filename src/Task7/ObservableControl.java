package Task7;

import java.util.ArrayList;
import java.util.List;
import Task3.View;

/**
 * Управління спостерігачами. Observer Pattern
 *
 * @author Sofiia Kyrychok
 */
public class ObservableControl implements Observable {

    /**
     * Список спостерігачів
     */
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Реалізація методу addObserver
     *
     * @param observer спостерігач
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Реалізація методу removeObserver
     *
     * @param observer спостерігач
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Реалізація методу notifyObservers
     *
     * @param view дані для спостерігачів
     */
    @Override
    public void notifyObservers(View view) {
        for (Observer observer : observers) {
            observer.update(view);
        }
    }

}
