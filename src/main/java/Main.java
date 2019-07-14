import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.port;
import static spark.Spark.get;

public class Main {

    public static void main(String[] args) throws Exception {

        port(8090);

        ItemController itemController = new ItemController();

        /**
         * endpoint de busqueda normal
         */

        get("search" , (request, response) -> {

            String qr = request.queryParams("q");

            HashMap<String, Item[]> item = itemController.getResponse(qr);

            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));

        });

        /**
         * endpoint de busqueda de solamente titulos
         */

        get("title" , (request, response) -> {

            String qr = request.queryParams("q");

            List<String> item = itemController.getTitle(qr);

            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));

        });

        /**
         * endpoint de ordenamiento por precio o listing type
         */

        get("sorted" , (request, response) -> {

            String qr = request.queryParams("q");
            String type = request.queryParams("type");
            String ord = request.queryParams("order");


            List<Item> item = itemController.sorted(qr , type , ord);

            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));

        });

        /**
         * endpoint de filtrado por rango de precios
         */

        get("filterPrice" , (request, response) -> {

            String qr = request.queryParams("q");
            String min = request.queryParams("min");
            String max = request.queryParams("max");


            List<Item> item = itemController.filterPrice(qr , min , max);

            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));

        });

        /**
         * endpoint de busqueda si contiene goodquality
         */

        get("containsGoodQuality" , (request, response) -> {

            String qr = request.queryParams("q");

            List<Item> item = itemController.containsGoodQuality(qr);

            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));

        });


    }
}
