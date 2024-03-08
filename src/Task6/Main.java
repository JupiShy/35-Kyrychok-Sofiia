package Task6;

import Task3.View;
import Task4.ViewableTable;
import Task5.ChangeConsoleCommand;
import Task5.GenerateConsoleCommand;
import Task5.Menu;
import Task5.RestoreConsoleCommand;
import Task5.SaveConsoleCommand;
import Task5.SortConsoleCommand;
import Task5.UndoConsoleCommand;
import Task5.ViewConsoleCommand;

/**Обчислення та відображення результатів
 *
 * @author Sofiia Kyrychok
 */
public class Main {

    /**
     * Об'єкт, рреалізуючий інтерфейс {@linkplain View}; обслуговує колекцію
     * об'єктів {@linkplain Task2.Item2d};
     *
     *
     * Ініціалізуються за допомогою Factory Method
     */
    private View view = new ViewableTable().getView();
    /**
     * Об'єкт класу {@linkplain Menu}; макрокоманда (Pattern Command)
     */
    private Menu menu = new Menu();

    /**
     * Обработка команд пользователя
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.add(new SortConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }

    /**
     * Виконується при запуску команди
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
