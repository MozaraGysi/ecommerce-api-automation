package OCC.Utils;

import OCC.DTOs.Request.*;
import OCC.Enums.GrantTypeEnum;
import OCC.Fixtures.CreditCardRequestDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import static OCC.Enums.GrantTypeEnum.APPLE_ID;
import static OCC.Enums.GrantTypeEnum.FACEBOOK;
import static OCC.Enums.GrantTypeEnum.PASSWORD;

public class APIClient {

    public static Response postAuthorization(AuthorizationRequestDTO requestDTO) {
        RestAssured.baseURI = Utils.getBaseUrl(true);
        GrantTypeEnum grantTypeEnum = GrantTypeEnum.valueOf(requestDTO.getGrantType().toUpperCase());

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", requestDTO.getContentType());
        request.formParam("client_id", requestDTO.getClientId());
        request.formParam("client_secret", requestDTO.getClientSecret());
        request.formParam("scope", requestDTO.getScope());
        request.formParam("grant_type", requestDTO.getGrantType());

        if (PASSWORD.equals(grantTypeEnum)) {
            request.formParam("username", requestDTO.getUsername());
            request.formParam("password", requestDTO.getPassword());
            request.formParam("site_uid", requestDTO.getSiteUid());
        }

        if (APPLE_ID.equals(grantTypeEnum)) {
            request.formParam("username", requestDTO.getUsername());
            request.formParam("userAppleId", requestDTO.getUserAppleId());
            request.formParam("firstName", requestDTO.getFirstName());
            request.formParam("lastName", requestDTO.getLastName());
            request.formParam("site_uid", requestDTO.getSiteUid());
        }

        if (FACEBOOK.equals(grantTypeEnum)) {
            request.formParam("facebook_token", requestDTO.getFacebookToken());
            request.formParam("site_uid", requestDTO.getSiteUid());
        }

        Response response = request.post("/arezzocoocc/oauth/token");
        response.getBody().print();

        return response;
    }

    public static Response getProduct(ProductCategorySearchPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/products/search");

        response.getBody().print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response getOptionslist(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/password-reset/request-recovery-options");

        response.getBody().print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response postPassword(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.post("/password-reset/request");

        response.getBody().print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response getReceivedcode(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/password-reset/check-received-code");

        response.getBody().print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response postChangePassword(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.post("/password-reset/change");

        response.getBody().print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response getStores(StoreFinderSearchRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/stores");

        response.getBody().print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response getHomepage(CmsPageContentRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/cms/pages/homepageHeadless");

        response.getBody().print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response putAddressesDelivery() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.put("/users/current/carts/current/addresses/delivery?addressId="+Utils.getIdAddress());
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response getDeliveryModes() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.param("executeSourcing",true);
        Response response = request.get("/users/current/carts/current/deliverymodes?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());

        return response;
    }

    public static Response getPaymentMethods() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.sessionId(Utils.getJSessionId());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.get("/users/current/carts/current/payment-methods?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());

        return response;
    }

    public static Response putPaymentMethod(String paymentMethod) {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode="+paymentMethod);
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());

        return response;
    }

    public static Response postOrderBoleto() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());

        return response;
    }

    public static Response postOrder(CreditCardRequestDTO creditCardRequestDTO) {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        request.body(creditCardRequestDTO.toJson().toString());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());

        return response;
    }

}
