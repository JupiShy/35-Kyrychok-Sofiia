package Task6;

import Task5.Command;

/**
 * Представляє методи для розміщення та вилучення задач обробником потоку;
 * Pattern Worker Thread
 *
 * @author Sofiia Kyrychok
 */
public interface Queue {

    /**
     * Додає нову задачу в чергу; Pattern Worker Thread
     *
     * @param cmd нова задача
     */
    void put(Command cmd);

    /**
     * Видаляє задачу з черги; Pattern Worker Thread
     *
     * @return видаляєма задача
     */
    Command take();
}
