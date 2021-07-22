package OCC.Pages;

import OCC.Fixtures.CartDTOFixture;
import OCC.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;


public class CartPage {

    public static void POST_Cart() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.post("/arezzocoocc/v2/"+Utils.getSite_UID()+"/users/current/carts?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void POST_Entry() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.body(new CartDTOFixture().withDefaultProduct().build().toJson().toString());
        Response response = request.post("/arezzocoocc/v2/"+Utils.getSite_UID()+"/users/current/carts/current/entries?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void POST_Entry_SellerExterno() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.body(new CartDTOFixture().withExternalSellerProduct().build().toJson().toString());
        Response response = request.post("/arezzocoocc/v2/"+Utils.getSite_UID()+"/users/current/carts/current/entries?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_Cart() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/arezzocoocc/v2/"+Utils.getSite_UID()+"/users/current/carts/current?reset=true&fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
