import java.util.Map;

import static spark.Spark.*;

public class UserController {

    public UserController() {
        DefineRoutes();
    }

    private void DefineRoutes() {

        UserService userService = new UserService();

        // http://localhost:8081/users/2
        get("/users/:id", (request, response) -> "User: username=test, email=test@test.net");

        //http://localhost:8081/hello/<name>
        get("/hello/:name", (req, res) -> {
            return "Hello World to :" + req.params(":name");
        });

        /**
         * Get - Give me specific user with the id
         * http://localhost:8081/user/2396
         */
        get("/user/:id", (request, response) -> {
            try {
                Map<Integer, String> result = userService.getUser(request.params(":id"));
                response.status(result.keySet().stream().findFirst().get());
                response.body(result.values().stream().findFirst().get());
                return response.body();
            } catch (Throwable t) {
                return "Unable to Fetch User with id : " + request.params(":id") +
                        "\r\n" + "Exception in routing logic : " + t.getLocalizedMessage();
            }
        });

        /**
         * Creates a new user
         */
        post("/createuser", (request, response) -> {
            try {
                String reqBody = request.body();
                Map<Integer, String> result = userService.addUser(reqBody);
                response.status(result.keySet().stream().findFirst().get());
                response.body(result.values().stream().findFirst().get());
                return response.body();
            } catch (Throwable t) {
                return "Unable to Add User with body : " + request.body()+
                        "\r\n" + "Exception in routing logic : " + t.getLocalizedMessage();
            }
        });
    }


    public void stopControllerService() {
        stop();
    }
}
