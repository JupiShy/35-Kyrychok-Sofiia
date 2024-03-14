package Task7;

import Task3.View;

/**Спостерігач. Повідомляє про зміни в консоль
 * Observer Pattern
 * @author Sofiia Kyrychok
 */
public class ChangesObserver implements Observer{

    @Override
    public void update(View view) {
        System.out.println("Changes happened.");
    }
}
