package Task4;

import java.util.Formatter;
import Task2.Item2d;
import Task3.ViewResult;

/**
 *
 * @author megas
 */
public class ViewTable extends ViewResult {

    /**
     * Ширина таблиці за замовчуванням
     */
    private static final int DEFAULT_WIDTH = 35;

    /**
     * Ширина таблиці
     */
    private short width;

    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    public ViewTable(short width) {
        this.width = width;
    }

    /**
     *
     * @param width
     * @param n
     */
    public ViewTable(short width, int n) {
        super(n);
        this.width = width;
    }

    /**
     *
     * @param width
     * @return
     */
    public int setWidth(short width) {
        return this.width = width;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     */
    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    /**
     *
     */
    private void outLineLn() {
        outLine();
        System.out.println();
    }

    private void outHeader() {
        Formatter fmt = new Formatter();
        int partWidth = (width - 3) / 2;
        fmt.format("%-" + (partWidth - 10) + "s | %-" + partWidth + "s | %s",
                "Number", "Binary", "Result");
        System.out.println(fmt.toString());
    }

    /**
     * Виводіть "тіло" таблиці шириною {@linkplain ViewTable#width} символів
     */
    private void outBody() { 
        
        int partWidth = (width - 3) / 2;
        for (Item2d item : getItems()) {
            Formatter fmt = new Formatter();
            fmt.format("%-" + (partWidth - 10) + "d | %-" + partWidth + "s | %s%n", item.getNum(), binaryCode(item.getNum()), item.getResult());
            System.out.printf(fmt.toString());
        }
    }

    public final void init(short width) { // method overloading
        this.width = width;
        viewInit();

    }

    /**
     *
     * @param width новая ширина таблицы.
     * @param stepNum передается методу <b>init(double)</b>
     */
    public final void init(short width, int stepNum) { // method overloading
        this.width = width;
        init(stepNum);
    }

    /**
     * {@linkplain ViewResult#init(double stepX) init(double stepX)}<br>
     * {@inheritDoc}
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
