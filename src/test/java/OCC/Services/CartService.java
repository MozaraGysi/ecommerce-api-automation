package OCC.Services;

import OCC.Fixtures.CartDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;


public class CartService {

    public static void POST_Cart() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.post("/users/current/carts?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void POST_Entry() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.body(new CartDTOFixture().withDefaultProduct().build().toJson().toString());
        Response response = request.post("/users/current/carts/current/entries?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void POST_Entry_SellerExterno() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.body(new CartDTOFixture().withExternalSellerProduct().build().toJson().toString());
        Response response = request.post("/users/current/carts/current/entries?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_Cart() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.get("/users/current/carts/current?reset=true&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
