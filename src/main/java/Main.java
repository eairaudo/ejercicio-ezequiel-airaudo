import com.google.gson.Gson;

import static spark.Spark.port;
import static spark.Spark.get;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws Exception {

        port(8090);

        ItemController itemController = new ItemController();

        String qr = "";

        Item[] item = itemController.getResponse(qr);

        get("/query" , (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson()
                            .toJsonTree(item)));
        });



    }
}
