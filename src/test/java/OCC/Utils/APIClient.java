package OCC.Utils;

import OCC.DTOs.Request.*;
import OCC.Enums.GrantTypeEnum;
import OCC.Handlers.AddressHandler;
import OCC.Handlers.AuthorizationHandler;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static OCC.Data.OCCDataTest.getBaseUrl;
import static OCC.Enums.GrantTypeEnum.APPLE_ID;
import static OCC.Enums.GrantTypeEnum.FACEBOOK;
import static OCC.Enums.GrantTypeEnum.PASSWORD;

public class APIClient {

    public static Response postAuthorization(AuthorizationRequestDTO requestDTO) {
        RestAssured.baseURI = getBaseUrl(true);
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
        RestAssured.baseURI = getBaseUrl(false);

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
        RestAssured.baseURI = getBaseUrl(false);

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
        RestAssured.baseURI = getBaseUrl(false);

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
        RestAssured.baseURI = getBaseUrl(false);

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
        RestAssured.baseURI = getBaseUrl(false);

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
        RestAssured.baseURI = getBaseUrl(false);

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
        RestAssured.baseURI = getBaseUrl(false);

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

    public static Response getHomepageApp(CmsPageContentRequestDTO requestDTO) {
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("homepage");

        response.getBody().print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response putAddressesDelivery() {
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.put("/users/current/carts/current/addresses/delivery?addressId="+AddressHandler.getAddress().getIdAddress());
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response postCart(CartRequestDTO cartRequestDTO){
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", cartRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.post("/users/current/carts?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        
        return response;
    }

    public static Response postRegisterNewUser(UserRequestDTO userRequestDTO){
        RestAssured.baseURI = getBaseUrl(false);
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", userRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.queryParams(userRequestDTO.toMap());
        request.body(userRequestDTO.toJson().toString());
        Response response = request.post("/users?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response getDeliveryModes(DeliveryModeRequestDTO deliveryModeRequestDTO) {

        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type",deliveryModeRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.param("executeSourcing",true);
        Response response = request.get("/users/current/carts/current/deliverymodes?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        return response;
    }

    public static Response postEntry(CartRequestDTO cartRequestDTO){

        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", cartRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.body(cartRequestDTO.toJson().toString());
        Response response = request.post("/users/current/carts/current/entries?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response getPaymentMethods(PaymentModeRequestDTO paymentModeRequestDTO) {
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type",paymentModeRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.sessionId(Utils.getJSessionId());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.get("/users/current/carts/current/payment-methods?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());
        return response;
    }

    public static Response postAddresses(AddressRequestDTO addressRequestDTO){
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", addressRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.queryParams(addressRequestDTO.toMap());
        request.body(addressRequestDTO.toJson().toString());
        Response response = request.post("/users/current/addresses?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response putPaymentMethod(String paymentMethod) {
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.put("/users/current/carts/current/payment-method?paymentMethodCode="+paymentMethod);
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Utils.setJSessionId(response.getSessionId());

        return response;
    }

    public static Response postOrderBoleto(BoletoRequestDTO boletoRequestDTO) {
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type",boletoRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        return response;
    }

    public static Response postEntrySellerExterno(CartRequestDTO cartRequestDTO){
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", cartRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.body(cartRequestDTO.toJson().toString());
        Response response = request.post("/users/current/carts/current/entries?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response getAddresses(AddressRequestDTO addressRequestDTO) {
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", addressRequestDTO.getContentType());
        request.header("Authorization", "Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.get("/users/current/addresses?fields=FULL");
        AddressHandler.handleAddress(response);
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;

    }

    public static Response getCart(CartRequestDTO cartRequestDTO){
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", cartRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.get("/users/current/carts/current?reset=true&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

    public static Response postOrder(CreditCardRequestDTO creditCardRequestDTO) {
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type",creditCardRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.sessionId(Utils.getJSessionId());
        request.body(creditCardRequestDTO.toJson().toString());
        Response response = request.post("/users/current/orders?cartId=current&fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        System.out.println(response.jsonPath().get("code").toString());
        return response;
    }

    public static Response patchUser(UserRequestDTO userRequestDTO){
        RestAssured.baseURI = getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", userRequestDTO.getContentType());
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.param("fields","FULL");
        request.queryParams(userRequestDTO.toMap());
        request.body(userRequestDTO.toJson().toString());
        Response response = request.patch("/users/current/?fields=FULL");
        response.print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());

        return response;
    }

}
