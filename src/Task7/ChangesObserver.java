package Task7;

import Task2.Item2d;
import Task3.View;
import Task4.ViewableTable;

/**
 * Observer Pattern
 * @author Sofiia Kyrychok
 */
public class ChangesObserver implements Observer{

    @Override
    public void update(View view) {
        System.out.println("Changes happened.");
    }
}
