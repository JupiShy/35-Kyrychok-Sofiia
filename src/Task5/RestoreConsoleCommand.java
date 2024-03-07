package Task5;

import Task3.View;

/**Консольна команда Restore
 *
 * @author Sofiia Kyrychok
 */
public class RestoreConsoleCommand implements ConsoleCommand {

    private View view;

    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'r';
    }

    @Override
    public String toString() {
        return "'r'estore";
    }

    @Override
    public void execute() {
        System.out.println("Restore last saved.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}
