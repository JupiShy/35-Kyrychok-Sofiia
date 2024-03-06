package Task3;

import Task2.Item2d;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Киричок Софія
 */
public class ViewResult implements View {

    /**
     * Ім'я файлу, що використовується при серіалізації
     */
    private static final String FNAME = "items.bin";

    /**
     * Визначає кількість значень для обрахування за замовчуванням
     */
    private static final int DEFAULT_NUM = 5;

    /**
     * Колекція аргументів та результатів обчислень
     */
    private ArrayList<Item2d> items = new ArrayList<Item2d>();

    /**
     * Викликає ViewResult з параметром DEFAULT_NUM
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /**
     * Ініціалізує колекцію {@linkplain ViewResult#items}
     *
     * @param n кількість елементів
     */
    public ViewResult(int n) {
        for (int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }

    /**
     * Отримати значення {@linkplain ViewResult#items}
     *
     * @return значення посилання на об'єкт {@linkplain ArrayList}
     */
    public ArrayList<Item2d> getItems() {
        return items;
    }

    /**
     * Обраховує кількість повних тетрад в двійковому числі
     *
     * @return int кількість повних тетрад
     */
    public int countTetrads(String binaryString) {

        return binaryString.length() / 4;
    }

    /**
     * Переводить десяткове чисто в двійкове
     *
     * @return String двійковий код числа
     */
    public String binaryCode(int num) {

        String binaryString = Integer.toBinaryString(num);
        return binaryString;
    }

    /**
     * Визначає значення функції, зберігає результат в колекції
     * {@linkplain ViewResult#items}
     *
     * @param stepNum крок збільшення аргументу
     */
    public void init(int stepNum) {
        int num = 0;
        for (Item2d item : items) {
            item.setNum(num);
            item.setResult(countTetrads(binaryCode(num)));
            num += stepNum;
        }
    }

    /**
     * Викликає init(int stepNum) з випадковим значенням аргументу
     */
    @Override
    public void viewInit() {
        Random random = new Random();
        init(random.nextInt(5001));
    }

    /**
     * Реалізація методу viewSave()
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    /**
     * Реалізація методу viewRestore()
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }

    /**
     * Реалізація методу viewHeader()
     */
    @Override
    public void viewHeader() {
        System.out.println("Calculating...");
    }

    /**
     * Реалізація методу viewBody()
     */
    @Override
    public void viewBody() {
        for (Item2d item : items) {
            System.out.println("\nNumber: " + item.getNum());
            System.out.println("Binary code: " + binaryCode(item.getNum()));
            System.out.println("Amount of full tetrads: " + item.getResult());
        }
    }

    /**
     * Реалізація методу viewFooter()
     */
    @Override
    public void viewFooter() {
        System.out.println("\nEnd.\n");
    }

    /**
     * Реалізація методу viewShow()
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
