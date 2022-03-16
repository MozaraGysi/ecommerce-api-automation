package OCC.Services;

import OCC.Fixtures.CreditCardDTOFixture;
import OCC.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class CheckoutService {

    public static void putAddressesDelivery() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        Response response = request.put("/users/current/carts/current/addresses/delivery?addressId="+Utils.getIdAddress());
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void getDeliveryModes() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        request.param("executeSourcing",true);
        Response response = request.get("/users/current/carts/current/deliverymodes?fields=FULL");
        Utils.setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void getPaymentMethods() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.sessionId(Utils.getJSessionId());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/users/current/carts/current/payment-methods?fields=FULL");
        Utils.setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void putPaymentMethod() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode=CreditCard");
        Utils.setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void putPaymentMethodBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode=Boleto");
        Utils.setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void postOrderBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        Utils.setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void postOrder() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        request.sessionId(Utils.getJSessionId());
        request.body(new CreditCardDTOFixture().defaultCreditCard().build().toJson().toString());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        Utils.setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        Assertions.assertEquals(201, response.getStatusCode());
    }
}
