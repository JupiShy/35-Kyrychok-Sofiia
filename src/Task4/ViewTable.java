package Task4;

import java.util.Formatter;
import Task2.Item2d;
import Task3.ViewResult;

/**
 * ConcreteProduct. Pattern Factory Method<br>
 * Виведення у вигляді таблиці
 *
 * @author Киричок Софія
 */
public class ViewTable extends ViewResult {

    /**
     * Ширина таблиці за замовчуванням
     */
    private static final int DEFAULT_WIDTH = 51;

    /**
     * Ширина таблиці
     */
    private short width;

    /**
     * Встановлює {@linkplain ViewTable#width width} значенням
     * {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
     * Викликається конструктор суперкласу
     * {@linkplain ViewResult#ViewResult() ViewResult()}
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /**
     * Встановлює {@linkplain ViewTable#width} значенням width Викликається
     * конструктор суперкласу {@linkplain ViewResult#ViewResult() ViewResult()}
     *
     * @param width ширина таблиці
     */
    public ViewTable(short width) {
        this.width = width;
    }

    
    /**
     * Встановлює {@linkplain ViewTable#width} значенням width Викликається
     * конструктор суперкласу {@linkplain ViewResult#ViewResult() ViewResult()}
     *
     * @param width ширина таблиці
     * @param n кількість елементів колекції; передається суперконструктору
     */
    public ViewTable(short width, int n) {
        super(n);
        this.width = width;
    }
    
    /**
     * Встановлює {@linkplain ViewTable#width} значенням width
     *
     * @param width нова ширина таблиці
     * @return задана ширина таблиці
     */
    public int setWidth(short width) {
        return this.width = width;
    }

    /**
     * Повертає значення ширини таблиці
     *
     * @return ширина таблиці
     */
    public int getWidth() {
        return width;
    }

    /**
     * Виводить горизонтальний розділювач для таблиці шириною
     * {@linkplain ViewTable#width} символів
     */
    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    /**
     * Закінчує вивід розділювачем {@linkplain ViewTable#outLine()}
     *
     */
    private void outLineLn() {
        outLine();
        System.out.println();
    }

    /**
     * Виводить заголовок таблиці
     */
    private void outHeader() {
        Formatter fmt = new Formatter();
        int partWidth = (width - 3) / 2;
        fmt.format("%-" + (partWidth - 15) + "s | %-" + partWidth + "s | %s",
                "Number", "Binary", "Result");
        System.out.println(fmt.toString());
    }

    /**
     * Виводіть "тіло" таблиці символів
     */
    private void outBody() {

        int partWidth = (width - 3) / 2;
        for (Item2d item : getItems()) {
            Formatter fmt = new Formatter();
            fmt.format("%-" + (partWidth - 15) + "d | %-" + partWidth + "s | %s%n", item.getNum(), binaryCode(item.getNum()), item.getResult());
            System.out.printf(fmt.toString());
        }
    }

    /**
     * Перевантаження (overloading) методу суперкласу; визначає поле
     * {@linkplain ViewTable#width} значением width. Викликає метод
     * {@linkplain ViewResult#viewInit() viewInit()}
     *
     * @param width нова ширина таблиці
     */
    public final void init(short width) { // method overloading
        this.width = width;
        viewInit();

    }

    /**
     * Перевантаження (overloading) методу суперкласу; визначає поле
     * {@linkplain ViewTable#width} значением width. Для об'єкту
     * {@linkplain ViewTable} викликає метод
     * {@linkplain ViewTable#init(int stepNum)}
     *
     * @param width нова ширина таблиці
     * @param stepNum передається методу init(int)
     */
    public final void init(short width, int stepNum) { // method overloading
        this.width = width;
        init(stepNum);
    }

    /**
     * Перевизначення (overriding) методу суперкласу; виводить повідомлення про
     * виконання ініціалізації та викликає метод суперкласу.
     * {@linkplain ViewResult#init(int stepNum) init(int stepNum)}
     */
    @Override
    public void init(int stepNum) { // method overriding
        System.out.print("Initialization... ");
        super.init(stepNum);
        System.out.println("done. ");
    }

    /**
     * Вивід заголовка таблиці
     */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }

    /**
     * Вивід "тіла" таблиці
     */
    @Override
    public void viewBody() {
        outBody();
    }

    /**
     * Вивід кінця таблиці
     */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}
