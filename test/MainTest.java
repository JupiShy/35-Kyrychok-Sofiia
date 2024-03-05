import java.io.Serializable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import java.util.Random;
import Task3.ViewResult;

/**
 * Тестування коректності результатів обчислень та серіалізації/десеріалізації
 *
 * @author Киричок Софія
 */
public class MainTest implements Serializable {

    ViewResult view = new ViewResult(5);

    @Test
    public void testBinaryCode() {
        assertEquals("0", view.binaryCode(0));
        assertEquals("1", view.binaryCode(1));
        assertEquals("101", view.binaryCode(5));
        assertEquals("111111111", view.binaryCode(511));
        assertEquals("100000000000", view.binaryCode(2048));
    }
    
    /**Перевірка правильності обрахування повних тетрад*/
    @Test
    public void testCountTetrads() {
        assertEquals(1, view.countTetrads("1000"));
        assertEquals(1, view.countTetrads("1010101"));
        assertEquals(2, view.countTetrads("10001000"));
        assertEquals(3, view.countTetrads("100010001000"));
    }

    /**
     * Перевірка серіалізації (коректність відновлення даних)
     */
    @Test
    public void testRestore() {
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
}
