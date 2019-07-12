import java.util.Collection;
import java.util.HashMap;


public interface ItemService {

    public void addItem(Item[] item);
    public Collection<Item> getItems(HashMap<String, Item[]> item);
    public Item getItem(String id);
    public Item editItem(Item item) throws ItemException;
    public void deleteItem(String id);
    public boolean itemExist(String id);

}
