package Task2_1;

/**
 * Клас для знаходження рішення задачі з використанням агрегування
 * 
 * @author Софія Киричок
 */
public class Calculating {
     /**
     * Завдання 1.2
     * 
     * Клас для знаходження рішення задачі з агрегуванням
     */
    private final Parameters parameters;
    
    public Calculating(Parameters parameters){
        this.parameters = parameters;
    }
    
    /**
     * Обчислює добуток параметрів та призначає це значення змінній result класу Parameters
     */
    public void calculate(){
        int result = parameters.getParam1() * parameters.getParam2();
        parameters.setResult(result);
    }
}
