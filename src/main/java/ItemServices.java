import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import static spark.Spark.port;
import static spark.Spark.get;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ItemServices {

    Item[] obtainResponse (String query) throws Exception{


        URL url = new URL("https://api.mercadolibre.com/sites/MLA/search?q="+ query);
        URLConnection urlConnection = url.openConnection();

        HttpURLConnection connection = null;

        if(urlConnection instanceof HttpURLConnection){
            connection = (HttpURLConnection) urlConnection;
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

        } else {
            System.out.println("Url invalida");
            return new Item[0];
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


        String urlString = "";
        String current = null;

        while ((current = in.readLine()) != null) {
            urlString += current;
        }


        JsonObject jsonObject = new JsonParser().parse(urlString).getAsJsonObject();
        Gson gson = new Gson();


        Item[] item = gson.fromJson( jsonObject.getAsJsonArray("results") , Item[].class);

        return item;

    }
}
