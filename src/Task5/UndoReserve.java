package Task5;

import Task2.Item2d;
import Task3.View;
import Task3.ViewResult;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**Виконує функціонал консольної команди Undo
 *
 * @author Sofiia Kyrychok
 */
public class UndoReserve {

    private static final String FNAME1 = "last.bin";
    private static final String FNAME2 = "back.bin";

    private ArrayList<Item2d> items;
    
    private View view;

    public UndoReserve(View view) {
        this.view = view;
    }
    

    public void write() throws IOException, Exception {

        items = ((ViewResult) view).getItems();
        reWrite();
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME1));
        os.writeObject(items);
        os.flush();
        os.close();
        //System.out.println("Zapisav F1 write");
    }

    @SuppressWarnings("unchecked")
    public void reWrite() throws Exception {

        items = ((ViewResult) view).getItems();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME1));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME2));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    @SuppressWarnings("unchecked")
    public void undo() throws Exception {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME2));
            items = (ArrayList<Item2d>) is.readObject();
            is.close();
        } catch (ClassNotFoundException ex) {
        }
    }
}
