package Task6;

import java.util.concurrent.TimeUnit;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.Command;

/**
 * Задача, що використовується обробником потоку; Pattern Worker Thread
 *
 * @author Sofiia Kyrychok
 */
public class MinMaxCommand implements Command /*, Runnable */ {

    /**
     * Зберігає результат обробки колекції
     */
    private int resultMin = -1;
    /**
     * Зберігає результат обробки колекції
     */
    private int resultMax = -1;
    /**
     * Прапорець готовності результату
     */
    private int progress = 0;
    /**
     * Обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private ViewResult viewResult;

    /**
     * Повертає поле {@linkplain MinMaxCommand#viewResult}
     *
     * @return значення {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Встановлює поле {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult значення для {@linkplain MinMaxCommand#viewResult}
     * @return нове значення {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Ініціалізує поле {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult об'єкт класу {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Повертає результат
     *
     * @return поле {@linkplain MinMaxCommand#resultMin}
     */
    public int getResultMin() {
        return resultMin;
    }

    /**
     * Повертає результат
     *
     * @return поле {@linkplain MinMaxCommand#resultMax}
     */
    public int getResultMax() {
        return resultMax;
    }

    /**
     * Перевіряє готовність результату
     *
     * @return false - якщо результат знайдено, інакше - true
     * @see MinMaxCommand#result
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

        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            if (item.getNum() > 0) {
                if ((resultMax == -1) || (viewResult.getItems().get(resultMax).getNum() > item.getNum())) {
                    //resultMax = idx;
                }
                if ((resultMin == -1) || (viewResult.getItems().get(resultMin).getNum() > item.getNum())) {
                    resultMin = idx;
                }
            }

            idx++;
            progress = idx * 100 / size;

            if (idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }

        System.out.print("MinMax done. ");

        if (resultMin > -1) {
            System.out.print("Min positive #" + resultMin + " found: " + viewResult.getItems().get(resultMin).getNum());
        } else {
            System.out.print("Min positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max negative #" + resultMax + " found: " + viewResult.getItems().get(resultMax).getNum());
        } else {
            System.out.println(" Max negative item not found.");
        }
        progress = 100;
    }
}
