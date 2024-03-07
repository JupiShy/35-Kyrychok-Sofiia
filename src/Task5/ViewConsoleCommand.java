package Task5;

import Task3.View;

/**
 *
 * @author Sofiia Kyrychok
 */
public class ViewConsoleCommand implements ConsoleCommand {

    private final View view;

    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'v';
    }

    @Override
    public String toString() {
        return "'v'iew";
    }

    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}
