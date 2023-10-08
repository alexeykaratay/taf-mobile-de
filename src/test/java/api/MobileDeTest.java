package api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MobileDeTest {

    @DisplayName("GET Request mobile.de Task 1")
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

    @DisplayName("POST request mobile.de Task 2")
    @Test
    public void postTest1() {
        int carId = 375739602;
        String urlPost = "https://suchen.mobile.de/fahrzeuge/svc/my/parkings/" + carId;
        String body = "{\n" +
                "    \"adId\": \"" + carId + "\",\n" +
                "    \"ref\": null,\n" +
                "    \"refId\": null\n" +
                "}";
        given()
                .body(body)
                .header("Content-Type", "application/json")
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .header("x-mobile-vi", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJmZDM5MWZjMS00YmI3LTRkZjQtYTUxMS04YWIxNTJkOTRiZDIiLCJpYXQiOjE2Nzg4OTg3OTh9.4i0QiqIXw9FZOhuJQNs38I2pUL99pQgmEaOjwkCO4NY")
                .post(urlPost)
                .then()
                .statusCode(201)
                .assertThat()
                .body("adId", equalTo(carId));
    }

    @DisplayName("POST request mobile.de Task 3")
    @Test
    public void postTest2() {
        String urlPost = "https://www.mobile.de/api/my/account";
        String body = "{\n" +
                "    \"email\": \"test@gmail.com\",\n" +
                "    \"password\": \"1q@W3e4r\",\n" +
                "    \"privacy\": true,\n" +
                "    \"generalTermsApproved\": true,\n" +
                "    \"privacySettings\": [\n" +
                "        \"ALLOW_MARKET_RESEARCH\",\n" +
                "        \"ALLOW_MARKETING_ACTIVITIES\"\n" +
                "    ]\n" +
                "}";
        given()
                .body(body)
                .header("Content-Type", "application/json")
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .header("x-mobile-client", "de.mobile.cis")
                .post(urlPost)
                .then()
                .statusCode(400)
                .assertThat()
                .body("[0].field", equalTo("email"))
                .body("[0].code", equalTo("account-exists"))
                .body("[0].message", equalTo("Diese E-Mail-Adresse ist bereits registriert."));
    }

    @DisplayName("POST request mobile.de Task 4")
    @Test
    public void postTest3() {
        String urlPost = "https://www.mobile.de/api/my/account";
        String body = "{" +
                "\"email\":\"\"," +
                "\"password\":\"1q@W3e4r\"," +
                "\"privacy\":true," +
                "\"generalTermsApproved\":true," +
                "\"privacySettings\":[]," +
                "\"optIns\":[\"SOFT_OPTIN_AUTO\"]" +
                "}";

        given()
                .body(body)
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .headers("content-type", "application/json; charset=utf-8")
                .header("x-mobile-client", "de.mobile.cis")
                .when()
                .post(urlPost)
                .then()
                .statusCode(400)
                .assertThat()
                .body("[0].field", equalTo("email"))
                .body("[0].code", equalTo("email-empty"))
                .body("[0].message", equalTo("Bitte geben Sie eine E-Mail-Adresse ein."))
                .body("[1].field", equalTo("email"))
                .body("[1].code", equalTo("email-invalid"))
                .body("[1].message", equalTo("Die eingegebene E-Mail-Adresse ist ungültig."));
    }

    @DisplayName("POST request mobile.de Task 5")
    @Test
    public void postTest4(){
        String urlPost = "https://www.mobile.de/api/my/account";
        String body = "{ \n" +
                "    \"email\": \"test1234523434@gmail.com\", \n" +
                "    \"password\": \"\", \n" +
                "    \"privacy\": true, \n" +
                "    \"generalTermsApproved\": true, \n" +
                "    \"privacySettings\": [ \n" +
                "        \"ALLOW_MARKET_RESEARCH\", \n" +
                "        \"ALLOW_MARKETING_ACTIVITIES\" \n" +
                "    ] \n" +
                "}";
        given()
                .body(body)
                .header("Content-Type", "application/json")
                .header("User-Agent", "PostmanRuntime/7.33.0")
                .header("x-mobile-client", "de.mobile.cis")
                .post(urlPost)
                .then()
                .statusCode(400)
                .assertThat()
                .body("[0].field", equalTo("password"))
                .body("[0].code", equalTo("password-empty"))
                .body("[0].message", equalTo("Bitte gib ein Passtwort ein."));
    }





}
