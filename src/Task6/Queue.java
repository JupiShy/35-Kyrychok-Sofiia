package Task6;

import Task5.Command;

/**
 *
 * @author Sofiia Kyrychok
 */
public interface Queue {

    /**
     * Добавляет новую задачу в очередь; шаблон Worker Thread
     *
     * @param cmd задача
     */
    void put(Command cmd);

    /**
     * Удаляет задачу из очереди; шаблон Worker Thread
     *
     * @return удаляемая задача
     */
    Command take();
}
