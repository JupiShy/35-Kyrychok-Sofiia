package Task4;

import Task3.ViewableResult;
import Task3.View;

/**
 * ConcreteCreator. Pattern Factory Method<br>
 * Оголошує метод, фабрикуючий об'єкти
 *
 * @author Киричок Софія
 * @see ViewableResult
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ViewableResult {

    /**
     * Створює відображуваний об'єкт {@linkplain ViewTable}
     *
     * @return View
     */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
