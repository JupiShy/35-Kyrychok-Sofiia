package Task6;

import Task5.Command;
import Task3.ViewResult;
import Task2.Item2d;
import java.util.concurrent.TimeUnit;

/**
 * Задача, що використовується обробником потоку; Pattern Worker Thread
 *
 * @author Sofiia Kyrychok
 */
public class AvgCommand implements Command {

    /**
     * Зберігає результат обробки колекції
     */
    private int result = 0;
    /**
     * Прапорець готовності результату
     */
    private int progress = 0;
    /**
     * Обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private ViewResult viewResult;

    /**
     * Повертає поле {@linkplain AvgCommand#viewResult}
     *
     * @return значення {@linkplain AvgCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Встановлює поле {@linkplain AvgCommand#viewResult}
     *
     * @param viewResult значення для {@linkplain AvgCommand#viewResult}
     * @return нове значення {@linkplain AvgCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Ініціалізує поле {@linkplain AvgCommand#viewResult}
     *
     * @param viewResult об'єкт класу {@linkplain ViewResult}
     */
    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Повертає результат
     *
     * @return поле {@linkplain AvgCommand#result}
     */
    public double getResult() {
        return result;
    }

    /**
     * Перевіряє готовність результату
     *
     * @return false - якщо результат знайдено, інакше - true
     * @see AvgCommand#result
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Використовується обробником потоку {@linkplain CommandQueue}; Pattern
     * Worker Thread
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Average executed...");
        result = 0;
        int idx = 1, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            result += item.getResult();
            progress = idx * 100 / size;

            if (idx++ % (size / 2) == 0) {
                System.out.println("Average " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(2000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        result /= size;
        System.out.println("Average amount of tetrads done. Result = " + result);

        progress = 100;
    }
}
