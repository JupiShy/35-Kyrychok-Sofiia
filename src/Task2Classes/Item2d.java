package Task2Classes;

import java.io.Serializable;

/**
 * Клас, що серіалізується, для зберігання параметрів і результатів обчислень
 * 
 * @author Киричок Софія
 */
public class Item2d implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**Аргумент обчислюваної функції */
    private int num;
    
    /**Результат обчислюваної функції */
    private int result;
    
    /**Ініціалізація {@linkplain Item2d#num}, стандартним значенням */
    public Item2d(){
        num = 0;
    }
    
    /**Встановлює значення аргументу функції
     * @param num значення для ініціалізації поля
     */
    public Item2d(int num){ 
        this.num = num;
    }

    /**Отримує значення {@linkplain Item2d#num}
     * @return num значення аргументу функції
     */
    public int getNum() {
        return num;
    }
    
    /**Встановлює значення {@linkplain Item2d#num}
     * @param num значення для ініціалізації поля
     */
    public void setNum(int num) {
        this.num = num;
    }
    
     /**Отримує значення {@linkplain Item2d#result}
     * @return result значення результату функції
     */
    public int getResult() {
        return result;
    }
    
     /**Встановлює значення {@linkplain Item2d#result}
     * @param result значення для ініціалізації поля
     */
    public void setResult(int result) {
        this.result = result;
    }
    
    /**
     * @return Повертає строку з значенням аргументу та результатом.
    **/
    @Override
    public String toString(){
        return "Number: " + num + "\nAmount of full tetrads: " + result;
    }
}
