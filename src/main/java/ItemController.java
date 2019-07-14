
import java.util.*;
import java.util.stream.Collectors;

public class ItemController {

    ItemServices itemServices;

    public ItemController() {

        this.itemServices = new ItemServices();
    }

    public HashMap<String, Item[]> getResponse(String query) throws Exception {


        Item[] items = itemServices.obtainResponse(query);

        HashMap<String, Item[]> results = new HashMap<>();

        results.put(query, items);

        return results;

    }

    public List<String> getTitle(String query) throws Exception {

        Item[] items = itemServices.obtainResponse(query);

        List<String> result = new ArrayList<>();

        for (Item i : items) {
            result.add(i.getTitle());
        }

        return result;

    }

    public List<Item> sorted(String query ,String type , String ord) throws Exception {

        Item[] items = itemServices.obtainResponse(query);

        List<Item> result = Arrays.asList(items);

        if(type.equals("price")) {

            switch (ord.toUpperCase()) {
                case "ASC":
                    result.sort(Comparator.comparing(Item::getPrice));
                    break;
                case "DESC":
                    result.sort(Comparator.comparing(Item::getPrice).reversed());
                    break;
                default:
            }
        }else
            if (type.equals("listingtype")){
            switch (ord.toUpperCase()) {
                case "ASC":
                    result.sort(Comparator.comparing(Item::getListyngTypeId));
                    break;
                case "DESC":
                    result.sort(Comparator.comparing(Item::getListyngTypeId).reversed());
                    break;
                default:
            }

        }

        return result;
    }

    public List<Item> filterPrice(String query , String min , String max) throws Exception {

        Item[] items = itemServices.obtainResponse(query);

        int maximo = Integer.parseInt(max);
        int minimo = Integer.parseInt(min);

        List<Item> result = Arrays.asList(items);

        return result.stream().filter(p -> p.getPrice() > minimo && p.getPrice() < maximo).collect(Collectors.toList());

    }

    public List<Item> containsGoodQuality(String query) throws Exception {

        Item[] items = itemServices.obtainResponse(query);

        List<Item> filter = new ArrayList<>();


        for (Item i : items){
            if(i.getTags() != null){
                String [] tag = i.getTags();
                for (int n = 0; n < tag.length; n++){
                    if(tag[n].compareTo("good_quality_thumbnail") == 0){
                        filter.add(i); }
                }

            }
        }

        return filter;

    }

}
