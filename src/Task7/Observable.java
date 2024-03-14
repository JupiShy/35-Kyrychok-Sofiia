package Task7;

import Task3.View;

/**Інтерфейс управління спостерігачами
 * Observer Pattern
 *
 * @author Sofiia Kyrychok
 */
public interface Observable {

    /**
     * Додати спостерігач
     *
     * @param observer спостерігач
     */
    void addObserver(Observer observer);

    /**
     * Видалити спостерігач
     *
     * @param observer спостерігач
     */
    void removeObserver(Observer observer);

    /**
     * Надсилає повідомлення всім спостерігачам
     * @param view дані для спостерігачів
     */
    void notifyObservers(View view);
}
