package OCC.Utils;

import OCC.DTOs.Request.LoginPageRequestDTO;
import OCC.DTOs.Request.CmsPageContentRequestDTO;
import OCC.DTOs.Request.ProductCategorySearchPageRequestDTO;
import OCC.DTOs.Request.StoreFinderSearchRequestDTO;
import OCC.Handlers.AuthorizationHandler;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIClient {

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
}
