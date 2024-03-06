package Task4;

import Task3.ViewableResult;
import Task3.View;

/**
 *
 * @author megas
 */
public class ViewableTable extends ViewableResult {

    /**
     * Створює відображуваний об'єкт {@linkplain ViewTable}
     * @return View
     */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
