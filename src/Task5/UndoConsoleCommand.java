package Task5;

import Task3.View;
/**Консольна команда Undo 
 *
 * @author Sofiia Kyrychok
 */
public class UndoConsoleCommand implements ConsoleCommand {

    private final View view;
    
    public UndoConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'u';
    }

    @Override
    public String toString() {
        return "'u'ndo";
    }

    @Override
    public void execute() {
        UndoReserve un = new UndoReserve(view);
        System.out.println("Undo last command.");
        try {
            un.undo();
        } catch (Exception e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}
