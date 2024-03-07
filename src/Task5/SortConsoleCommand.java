package Task5;

import Task2.Item2d;
import Task3.View;
import Task3.ViewResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Консольна команда Sort
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

        UndoReserve un = new UndoReserve(view);
        try {
            un.write();
        } catch (IOException e) {
            System.out.println("Writing error: " + e);
        } catch (Exception ex) {
            Logger.getLogger(SortConsoleCommand.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("loshara");
        }
        ArrayList<Item2d> itemsList = ((ViewResult) view).getItems();
        Collections.sort(itemsList, Comparator.comparingDouble(Item2d::getNum));
        view.viewShow();
    }
}
