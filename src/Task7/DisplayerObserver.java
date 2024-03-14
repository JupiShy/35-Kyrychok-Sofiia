package Task7;

import Task2.Item2d;
import Task3.View;
import Task3.ViewResult;
import Application.GraphFrame;


/**Спостерігач відображення
 * Observer Pattern
 * @author Sofiia Kyrychok
 */
public class DisplayerObserver implements Observer {
    
    private GraphFrame frame;
    
    public DisplayerObserver(GraphFrame frame) {
        this.frame = frame;
    }
    
    public DisplayerObserver(){}
    
    @Override
    public void update(View view) {
        System.out.println("Updating...");
        
        frame.updateGraph(view);
    }
}
