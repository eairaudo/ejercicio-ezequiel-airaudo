import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.port;
import static spark.Spark.get;

public class Main {

    public static void main(String[] args) throws Exception {

        port(8090);

        ItemController itemController = new ItemController();

        get("search" , (request, response) -> {

            String qr = request.queryParams("q");

            Item[] item = itemController.getResponse(qr);

            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));

        });

        get("title" , (request, response) -> {

            String qr = request.queryParams("q");

            List<String> item = itemController.getTitle(qr);

            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));

        });

        get("sortByPrice" , (request, response) -> {

            String qr = request.queryParams("q");

            HashMap<String, Double> item = itemController.sortPrice(qr);

            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));

        });

    }
}
