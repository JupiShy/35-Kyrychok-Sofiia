package Task2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Виконує визначення та відображення результатів
 * 
 * @author Киричок Софія
 * @see Main#main
 */
public class Main {
    
    /**Об'єкт класу {@linkplain Calc} для обчислень*/
    private Calc calc = new Calc();
    
    /**Об'єкт класу {@linkplain Irem2d} для ініціалізації обчислюваних значень*/
    private Item2d item = new Item2d();
    
    /**Відображує меню*/
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    calc.show();
                    break;
                case 'g':
                    System.out.println("Generating new float number...");
                    Random random = new Random();
                    calc.init(random.nextInt(2501));
                    calc.show();
                    break;
                case 's':
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while (s.charAt(0) != 'q');
    }

    /**
     * Виконується при запуску програми
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Main main = new Main();
        main.menu();
    }
}
