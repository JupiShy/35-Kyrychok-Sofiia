package Task5;

import Task3.View;
import Task4.ViewableTable;

/**
 *
 * @author Sofiia Kyrychok
 */
public class Application {

    private static final Application instance = new Application();

    private Application() {
    }

    public static Application getInstance() {
        return instance;
    }

    private final View view = new ViewableTable().getView();

    private final Menu menu = new Menu();

    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.add(new SortConsoleCommand(view));
        menu.execute();
    }
}
