package api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MobileDeTest {

    @DisplayName("GET Request mobile.de")
    @Test
    public void getTest() {
        String url = "https://www.mobile.de/";
        given().header("User-Agent", "PostmanRuntime/7.33.0")
                .header("Content-Type", "application/json")
                .when()
                .get(url)
                .then()
                .statusCode(200);
    }

    @DisplayName("POST request mobile.de")
    @Test
    public void postTest() {
        int carId = 375739602;
        String urlPost = "https://suchen.mobile.de/fahrzeuge/svc/my/parkings/" + carId;
        String body = "{\n" +
                "    \"adId\": \"" + carId + "\",\n" +
                "    \"ref\": null,\n" +
                "    \"refId\": null\n" +
                "}";
        given().header("Content-Type", "application/json")
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .header("x-mobile-vi", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJmZDM5MWZjMS00YmI3LTRkZjQtYTUxMS04YWIxNTJkOTRiZDIiLCJpYXQiOjE2Nzg4OTg3OTh9.4i0QiqIXw9FZOhuJQNs38I2pUL99pQgmEaOjwkCO4NY")
                .body(body)
                .post(urlPost)
                .then()
                .statusCode(201)
                .assertThat()
                .body("adId", equalTo(carId));
    }
}
