package Task7;

import Task3.View;

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
