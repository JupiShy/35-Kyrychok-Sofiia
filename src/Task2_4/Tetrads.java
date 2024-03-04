package Task2_4;

/**
 * Підрахування кількості повних тетрад у двійковому поданні заданого десяткового числа.
 * 
 * @author Киричок Софія
 */
public class Tetrads {
    private float number;
    
    public Tetrads(float number){
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }
    
    public void countTetrads(){
        int intNumBits = Float.floatToIntBits(number);
        String binaryString = Integer.toBinaryString(intNumBits);
        int tetradaCount = binaryString.length() / 4;
        System.out.println("Binary code " + number + ": " + binaryString + ". Amount of full tetrads: " + tetradaCount);
    }
}
