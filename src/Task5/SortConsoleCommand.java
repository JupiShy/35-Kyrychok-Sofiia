package Task5;

import Task2.Item2d;
import Task3.View;
import Task3.ViewResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Sofiia Kyrychok
 */
public class SortConsoleCommand implements ConsoleCommand {

    private final View view;

    public SortConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'S';
    }

    @Override
    public String toString() {
        return "'S'ort";
    }

    @Override
    public void execute() {
        
        ArrayList<Item2d> itemsList = ((ViewResult) view).getItems();
        Collections.sort(itemsList, Comparator.comparingDouble(Item2d::getNum));
        view.viewShow();
    }
}
