package Task3;

/**Creator
 * Pattern Factory Method<br>
 * Оголошує метод, "фабрикуючий" об'єкти
 *
 * @author Киричок Софія
 * @see Viewable#getView()
 */
public interface Viewable {

    /**Створює об'єкт реалізуючий {@linkplain View}
     * @return View 
     */
    public View getView();
}
