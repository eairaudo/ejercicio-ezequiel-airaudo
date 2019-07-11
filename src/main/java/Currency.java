import com.google.gson.annotations.SerializedName;

public class Currency {
    private String symbol;
    private String description;
    @SerializedName("decimal_places")
    private int decimalPlaces;

    public Currency(String symbol, String description, int decimalPlaces) {
        this.symbol = symbol;
        this.description = description;
        this.decimalPlaces = decimalPlaces;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }
}
