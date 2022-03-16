package OCC.Services;

import OCC.Fixtures.CreditCardRequestDTOFixture;
import OCC.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class CheckoutService {

    public static void PUT_AddressesDelivery() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.put("/users/current/carts/current/addresses/delivery?addressId="+Utils.getID_ADDRESS());
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_DeliveryModes() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.param("executeSourcing",true);
        Response response = request.get("/users/current/carts/current/deliverymodes?fields=FULL");
        Utils.setCookies(response.getCookies());
        Utils.setJSESSIONID(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_PaymentMethods() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.sessionId(Utils.getJSESSIONID());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/users/current/carts/current/payment-methods?fields=FULL");
        Utils.setCookies(response.getCookies());
        Utils.setJSESSIONID(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void PUT_PaymentMethod() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.sessionId(Utils.getJSESSIONID());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode=CreditCard");
        Utils.setCookies(response.getCookies());
        Utils.setJSESSIONID(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void PUT_PaymentMethodBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.sessionId(Utils.getJSESSIONID());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode=Boleto");
        Utils.setCookies(response.getCookies());
        Utils.setJSESSIONID(response.getSessionId());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void POST_OrderBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.sessionId(Utils.getJSESSIONID());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        Utils.setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void POST_Order() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.sessionId(Utils.getJSESSIONID());
        request.body(CreditCardRequestDTOFixture.get().defaultCreditCard().build().toJson().toString());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        Utils.setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        Assertions.assertEquals(201, response.getStatusCode());
    }
}
