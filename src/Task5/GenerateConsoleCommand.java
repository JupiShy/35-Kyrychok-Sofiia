package Task5;

import Task3.View;
/**Консольна команда Generate
 *
 * @author Sofiia Kyrychok
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    
    private final View view;
    
    public GenerateConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'g';
    }
    
    @Override
    public String toString(){
        return "'g'enerate";
    }
    
    @Override
    public void execute(){
        System.out.println("Random generation.");
        view.viewInit();
        view.viewShow();
    }
}
