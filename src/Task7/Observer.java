package Task7;

import Task3.View;
/**Спостерігач
 * Observer Pattern
 * @author Sofiia Kyrychok
 */
public interface Observer {
    /**
     * Оновлення даних спостерігачів
     * @param view об'єкт, зміни в якому спостерігають
     */
    void update(View view);
}