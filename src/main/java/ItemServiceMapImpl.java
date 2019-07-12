import java.util.Collection;
import java.util.HashMap;


public class ItemServiceMapImpl implements ItemService {

    private HashMap<String, Item[]> itemMap;

    public ItemServiceMapImpl(){
        itemMap = new HashMap<>();
    }


    @Override
    public void addItem(Item[] item) {

    }

    @Override
    public Collection<Item> getItems(HashMap<String, Item[]> item) {
        return null;
    }

    @Override
    public Item getItem(String id) {
        return null;
    }

    @Override
    public Item editItem(Item item) throws ItemException {
        return null;
    }

    @Override
    public void deleteItem(String id) {

    }

    @Override
    public boolean itemExist(String id) {
        return false;
    }
}
