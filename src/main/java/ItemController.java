
public class ItemController {

    ItemServices itemServices;

    public ItemController(){

        this.itemServices = new ItemServices();
    }

    public Item[] getResponse (String query) throws Exception {
        return itemServices.obtainResponse(query);
    }
}
