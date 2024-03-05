import java.io.Serializable;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.Random;
import Task2.Calc;

/**
 * Тестування коректності результатів обчислень та серіалізації/десеріалізації
 *
 * @author Киричок Софія
 */
public class MainTest implements Serializable {

    /**
     * Перевірка функціональності класу {@linkplain Calc}
     */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        assertEquals(0, calc.countTetrads(0));
        assertEquals(2, calc.countTetrads(1000));
        assertEquals(3, calc.countTetrads(3578));
    }

    /**
     * Перевірка серіалізації (коректність відновлення даних) 
     */
    @Test
    public void testRestore() {
        Calc calc = new Calc();
        Random random = new Random();
        int num, result;
        for (int ctr = 0; ctr < 1000; ctr++) {
            num = random.nextInt(2501);

            // Ініціалізуємо об'єкт calc з випадковим числом num
            calc.init(num);

            // Отримуємо результат ініціалізації
            result = calc.getObject().getResult();

            try {
                // Зберігаємо стан
                calc.save();
            } catch (IOException e) {
                fail("Failed to save state");
            }

            // Імітуємо зміну стану
            calc.init(random.nextInt(2501));

            try {
                // Відновлюємо стан
                calc.restore();
            } catch (Exception e) {
                fail("Failed to restore state");
            }

            // Перевірка, чи відновлені дані вірно
            assertEquals(result, calc.getObject().getResult());
        }
    }
}
