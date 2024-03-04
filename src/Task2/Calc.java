package Task2;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Клас для знаходження рішення задачі з використанням агрегування
 *
 * @author Софія Киричок
 */
public class Calc {

    private static final String FNAME = "Item2d.bin";
    private Item2d result;

    public Calc() {
        result = new Item2d();
    }

    public int countTetrads(float num) {
        int intNumBits = Float.floatToIntBits(num);
        String binaryString = Integer.toBinaryString(intNumBits);
        System.out.println(binaryString);
        return binaryString.length() / 4;
    }
    
    public void init(float num){
        result.setNum(num);
        result.setResult(countTetrads(num));
    }
    
    public Item2d getObject(){
        return result;
    }
    
    public void setObject(Item2d result){
        this.result = result;
    }
    
    public void show(){
        System.out.println(result);
    }
    
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d) is.readObject();
        is.close();
    }
}
