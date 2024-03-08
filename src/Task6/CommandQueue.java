package Task6;

import java.util.Vector;
import Task5.Command;

/**
 * Створює обробник потоку, виконуючого об'єкти  інтерфейсом Command;
 * Pattern Worker Thread
 *
 * @author Sofiia Kyrychok
 */
public class CommandQueue implements Queue {

    /**
     * Черга задач
     */
    private Vector<Command> tasks;
    /**
     * Прапорецт очікування
     */
    private boolean waiting;
    /**
     * Прапорець завершення
     */
    private boolean shutdown;

    /**
     * Встановлює прапорець завершення
     */
    public void shutdown() {
        shutdown = true;
    }

    /**
     * Ініціалізація {@linkplain CommandQueue#tasks}
     * {@linkplain CommandQueue#waiting}
     * {@linkplain CommandQueue#waiting}; створює поток для класу
     * {@linkplain CommandQueue.Worker}
     */
    public CommandQueue() {
        tasks = new Vector<Command>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {

                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return (Command) tasks.remove(0);
    }

    /**
     * Обслуговує чергу задач; Pattern Worker Thread
     *
     * @see Runnable
     */
    private class Worker implements Runnable {

        /**
         * Вилучає з черги готові до виконання задачі; Pattern Worker Thread
         */
        @Override
        public void run() {
            while (!shutdown) {
                Command r = take();
                r.execute();
            }
        }
    }
}
