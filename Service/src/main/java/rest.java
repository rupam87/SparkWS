
import static spark.Spark.get;

import spark.Request;
import spark.Response;
import spark.Route;

public class rest {
    public static void main(String[] args) {

        // http://localhost:4567/users/2
        get("/users/:id", (request, response) -> "User: username=test, email=test@test.net");

        //http://localhost:4567/hello/rupam
        get("/hello/:name", (req, res) -> {
            return "Hello World to :" + req.params(":name");
        });

        
    }
}
