package Task5;

import Task2.Item2d;
import Task3.View;
import Task3.ViewResult;
import java.util.Random;

/**Консольна команда, що виконує зміну значень елементів на випадковий здвиг
 *
 * @author Sofiia Kyrychok
 */
public class ChangeConsoleCommand
        extends ChangeItemCommand
        implements ConsoleCommand {

    private View view;

    public View getView() {
        return view;
    }

    public View setView(View view) {
        return this.view = view;
    }

    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'c';
    }

    @Override
    public String toString() {
        return "'c'hange";
    }

    @Override
    public void execute() {
        Random random = new Random();

        System.out.println("Change item: scale factor " + setOffset(random.nextInt(20) + 1));
        for (Item2d item : ((ViewResult) view).getItems()) {
            if (item.getNum() > 950000) {
                System.out.println("Maximum numbers size reached.");
                break;
            } else {
                super.setItem(item);
                super.execute();
            }
        }
        view.viewShow();
    }
}
