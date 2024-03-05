package Task3;

/**ConcreteCreator
 * Pattern Factory Method<br>
 * Оголошує метод, "фабрикуючий" об'єкти
 * 
 * @author Киричок Софія
 */
public class ViewableResult implements Viewable {

    /**Створює відображуваний об'єкт {@linkplain ViewResult}*/
    @Override
    public View getView() {
        return new ViewResult();
    }
}
