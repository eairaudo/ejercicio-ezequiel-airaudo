import com.google.gson.annotations.SerializedName;

public class Item implements Comparable{

    private String id;
    @SerializedName("site_id")
    private  String siteId;
    private String title;
    private Double price;
    @SerializedName("currency_id")
    private String  currencyId;
    @SerializedName("listing_type_id")
    private String listyngTypeId;
    @SerializedName("stop_time")
    private String stopTime;
    private String thumbnail;
    private String[] tags;



    public Item(String id, String siteId, String title, Double price, String currencyId, String listyngTypeId, String stopTime, String thumbnail , String[] tags) {
        this.id = id;
        this.siteId = siteId;
        this.title = title;
        this.price = price;
        this.currencyId = currencyId;
        this.listyngTypeId = listyngTypeId;
        this.stopTime = stopTime;
        this.thumbnail = thumbnail;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getListyngTypeId() {
        return listyngTypeId;
    }

    public void setListyngTypeId(String listyngTypeId) {
        this.listyngTypeId = listyngTypeId;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
