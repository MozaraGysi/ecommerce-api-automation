package OCC.Services;

import OCC.Fixtures.CreditCardRequestDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class CheckoutService {

    public static void putAddressesDelivery() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.put("/users/current/carts/current/addresses/delivery?addressId="+Utils.getIdAddress());
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void getDeliveryModes() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.param("executeSourcing",true);
        Response response = request.get("/users/current/carts/current/deliverymodes?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void getPaymentMethods() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.sessionId(Utils.getJSessionId());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.get("/users/current/carts/current/payment-methods?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void putPaymentMethod() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode=CreditCard");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void putPaymentMethodBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode=Boleto");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void postOrderBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void postOrder() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        request.body(CreditCardRequestDTOFixture.get().defaultCreditCard().build().toJson().toString());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        Assertions.assertEquals(201, response.getStatusCode());
    }
}
