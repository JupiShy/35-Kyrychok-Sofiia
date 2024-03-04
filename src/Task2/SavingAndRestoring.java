package Task2;

import java.io.*;

/**
 * Розробити клас для демонстрації в діалоговому режимі збереження та
 * відновлення стану об'єкта, використовуючи серіалізацію. Показати особливості
 * використання transient полів.
 *
 * @author Киричок Софія
 */
public class SavingAndRestoring implements Serializable {

    private int ID;
    transient private String name;

    public SavingAndRestoring(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void SerAndDeser() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
            out.writeObject(this);
            out.close();
            System.out.println("Serialized:\n" + byteArrayOutputStream.toString());

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteArrayInputStream);
            SavingAndRestoring newObject = (SavingAndRestoring) in.readObject();
            in.close();
            System.out.println("Deserialized:\n" + newObject.toString());

            byteArrayOutputStream.close();
            byteArrayInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\nName: " + name;
    }
}
