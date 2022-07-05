import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class UserService {

    Map<Integer, String> returnObject;

    public UserService() {
        returnObject = new HashMap<Integer, String>();
    }

    /**
     * Invoking Go-Rest Api to create user. Typically you would put your
     * data creation and persistence logic in here.
     *
     * @param body
     */
    public Map<Integer, String> addUser(String body) {
        returnObject.clear();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer 75d58bf991b7ad2730b72881d7de268d410101b9bbab38ee963fe6abd98f6108");
        headers.put("Content-Type", "application/json");
        Response response = given()
                .baseUri("https://gorest.co.in")
                .headers(headers)
                .body(body)
                .when()
                .post("/public/v2/users")
                .then()
                .extract().response();
        returnObject.put(response.statusCode(), response.getBody().prettyPrint());
        return returnObject;
    }

    /**
     * Get the user by user id
     * @param id
     */
    public Map<Integer, String> getUser(String id) {
        returnObject.clear();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer 75d58bf991b7ad2730b72881d7de268d410101b9bbab38ee963fe6abd98f6108");
        Response response = given()
                .baseUri("https://gorest.co.in")
                .headers(headers)
                .when()
                .get("/public/v2/users/" + id)
                .then()
                .extract().response();
        returnObject.put(response.statusCode(), response.getBody().prettyPrint());
        return returnObject;
    }

}
