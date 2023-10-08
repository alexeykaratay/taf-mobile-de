package api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MobileDeTest {
    private String url = "https://www.mobile.de/";
    @DisplayName("GET Request mobile.de")
    @Test
    public void getTest(){
        given().header("User-Agent", "PostmanRuntime/7.33.0")
                .header("Content-Type", "application/json")
                .when()
                .get(url)
                .then()
                .statusCode(200);
    }
}
