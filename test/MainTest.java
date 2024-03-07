
import java.io.Serializable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import java.util.Random;
import Task3.ViewResult;
import Task4.ViewTable;
import Task2.Item2d;
import Task5.ChangeItemCommand;
import Task5.ChangeConsoleCommand;

/**
 * Тестування коректності результатів обчислень та серіалізації/десеріалізації
 *
 * @author Киричок Софія
 */
public class MainTest implements Serializable {

    ViewResult view = new ViewResult(5);

    /**
     * Перевірка правильності переведення десяткового числа в двійкове
     */
    @Test
    public void testBinaryCode() {
        assertEquals("0", view.binaryCode(0));
        assertEquals("1", view.binaryCode(1));
        assertEquals("101", view.binaryCode(5));
        assertEquals("111111111", view.binaryCode(511));
        assertEquals("100000000000", view.binaryCode(2048));
    }

    /**
     * Перевірка правильності обрахування повних тетрад
     */
    @Test
    public void testCountTetrads() {
        assertEquals(1, view.countTetrads("1000"));
        assertEquals(1, view.countTetrads("1010101"));
        assertEquals(2, view.countTetrads("10001000"));
        assertEquals(3, view.countTetrads("100010001000"));
    }

    @Test
    public void testTask4() {
        ViewTable tbl = new ViewTable((short) 15, 10);
        assertEquals(15, tbl.getWidth());
        assertEquals(10, tbl.getItems().size());
    }

    /**
     * Перевірка серіалізації (коректність відновлення даних)
     */
    @Test
    public void testRestoreT3() {
        Random random = new Random();
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();

        view1.init(random.nextInt(10000));

        try {
            view1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        try {
            view2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        assertEquals(view1.getItems().size(), view2.getItems().size());
    }

    /**
     * Перевірка серіалізації (коректність відновлення даних)
     */
    @Test
    public void testRestoreT4() {
        Random random = new Random();
        ViewTable tbl1 = new ViewTable((short) 10, 1000);
        ViewTable tbl2 = new ViewTable();

        tbl1.init(random.nextInt(5001));

        try {
            tbl1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
    }

    /**
     * Перевірка здвигу чисел
     */
    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        Random random = new Random();
        cmd.setItem(new Item2d());
        int num, offset;
        for (int ctr = 0; ctr < 1000; ctr++) {
            num = random.nextInt(5001);
            cmd.getItem().setNum(num);
            offset = random.nextInt(10);
            cmd.setOffset(offset);
            cmd.execute();

            assertEquals(num * offset, cmd.getItem().getNum());
        }
    }

    /**
     * Тест відображення і виклику {@linkplain ChangeConsoleCommand} 
     */
    @Test
    public void testChangeConsoleCommand() {
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit();
        cmd.execute();
        assertEquals("'c'hange", cmd.toString());
        assertEquals('c', cmd.getKey());
    }
}
