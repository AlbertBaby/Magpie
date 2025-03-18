package RestService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class getUser {

    public Response getUserDetails(String userId) {
        RestAssured.baseURI = "https://api.example.com"; // Replace with your API base URL
        
        return given()
                .pathParam("id", userId)
                .when()
                .get("/users/{id}")
                .then()
                .extract()
                .response();
    }
}
