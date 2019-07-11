
import java.util.*;

public class ItemController {

    ItemServices itemServices;

    public ItemController(){

        this.itemServices = new ItemServices();
    }

    public Item[] getResponse (String query) throws Exception {
        return itemServices.obtainResponse(query);
    }

    public List<String> getTitle (String query) throws Exception {

        Item [] items = itemServices.obtainResponse(query);

        List <String> result = new ArrayList<>();

        for(Item i : items){
            result.add(i.getTitle());
        }

        return result;

    }

    public HashMap<String, Double> sortPrice (String query) throws Exception {

        Item [] items = itemServices.obtainResponse(query);

        HashMap<String, Double> sort = new HashMap<>();

        for(Item i : items){
            sort.put( i.getTitle() , i.getPrice());
        }

        return sort;

    }
}
