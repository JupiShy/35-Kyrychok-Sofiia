package Task7;

import Task3.View;
import Application.GraphFrame;


/**Спостерігач відображення
 * Observer Pattern
 * @author Sofiia Kyrychok
 */
public class DisplayerObserver implements Observer {
    
    /**
     * Вікно, в якому будуть відображатися зміни
     */
    private GraphFrame frame;
    
    /**
     * Передача вікна в клас
     * @param frame вікно з графіком
     */
    public DisplayerObserver(GraphFrame frame) {
        this.frame = frame;
    }
    
    /**
     * Оновлення графіку оновленими даними
     * @param view дані для спостерігача
     */
    @Override
    public void update(View view) {
        System.out.println("Updating...");
        
        frame.updateGraph(view);
    }
}
