package Task7;

import Task3.View;
/**
 * Observer Pattern
 *
 * @author Sofiia Kyrychok
 */
public interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(View view);
}
