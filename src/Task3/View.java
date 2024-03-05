package Task3;

import java.io.IOException;
/**
 * Product
 * Pattern Factory Method<br>
 * Інтерфейс фабрикуємих об'єктів. Оголошує методи відображення об'єктів
 * Оголошує методи відображення об'єктів
 * 
 * @author Киричок Софія
 */
public interface View {
    
    /**Відображення всього об'єкту*/
    public void viewShow();
    
    /**Показує заголовок*/
    public void viewHeader();
    
    /**Показує основну частину*/
    public void viewBody();
    
    /**Показує напис про закінчення*/
    public void viewFooter();
    
    /**Виконує ініціалізацію*/
    public void viewInit();
    
    /**Зберігає інформацію в файл*/
    public void viewSave() throws IOException;
    
    /**Відновлює раніше збережену інформацію*/
    public void viewRestore() throws Exception;
}
