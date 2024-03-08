package Task6;

import java.util.concurrent.TimeUnit;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.Command;

/**
 *
 * @author Sofiia Kyrychok
 */
public class MinMaxCommand implements Command /*, Runnable */ {

    /**
     * Хранит результат обработки коллекции
     */
    private int resultMin = -1;
    /**
     * Хранит результат обработки коллекции
     */
    private int resultMax = -1;
    /**
     * Флаг готовности результата
     */
    private int progress = 0;
    /**
     * Обслуживает коллекцию объектов {@linkplain ex01.Item2d}
     */
    private ViewResult viewResult;

    /**
     * Возвращает поле {@linkplain MinMaxCommand#viewResult}
     *
     * @return значение {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Устанавливает поле {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult значение для {@linkplain MinMaxCommand#viewResult}
     * @return новое значение {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Инициализирует поле {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult объект класса {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Возвращает результат
     *
     * @return поле {@linkplain MinMaxCommand#resultMin}
     */
    public int getResultMin() {
        return resultMin;
    }

    /**
     * Возвращает результат
     *
     * @return поле {@linkplain MinMaxCommand#resultMax}
     */
    public int getResultMax() {
        return resultMax;
    }

    /**
     * Проверяет готовность результата
     *
     * @return false - если результат найден, иначе - true
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Используется обработчиком потока {@linkplain CommandQueue}; шаблон Worker
     * Thread
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
