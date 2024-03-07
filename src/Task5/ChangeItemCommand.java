package Task5;

import Task2.Item2d;
import Task3.ViewResult;
/**
 *
 * @author Sofiia Kyrychok
 */
public class ChangeItemCommand implements Command{
    
    private Item2d item;
    
    private int offset;
    
    public Item2d setItem(Item2d item){
        return this.item = item;
    }
    
    public int setOffset(int offset){
        return this.offset = offset;
    }
    
    public int getOffset(){
        return offset;
    }
    
    @Override
    public void execute(){
        ViewResult view = new ViewResult();
        item.setNum(item.getNum() * offset);
        item.setResult(view.countTetrads(view.binaryCode(item.getNum())));
    }
}
