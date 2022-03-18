package OCC.Services;

import OCC.Fixtures.CreditCardDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class CheckoutService {

    public static void PUT_AddressesDelivery() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.put("/users/current/carts/current/addresses/delivery?addressId="+Utils.getID_ADDRESS());
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_DeliveryModes() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.param("executeSourcing",true);
        Response response = request.get("/users/current/carts/current/deliverymodes?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSESSIONID(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_PaymentMethods() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.sessionId(Utils.getJSESSIONID());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.get("/users/current/carts/current/payment-methods?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSESSIONID(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void PUT_PaymentMethod() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSESSIONID());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode=CreditCard");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSESSIONID(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void PUT_PaymentMethodBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSESSIONID());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode=Boleto");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSESSIONID(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void POST_OrderBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSESSIONID());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void POST_Order() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSESSIONID());
        request.body(new CreditCardDTOFixture().defaultCreditCard().build().toJson().toString());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        Assertions.assertEquals(201, response.getStatusCode());
    }
}
