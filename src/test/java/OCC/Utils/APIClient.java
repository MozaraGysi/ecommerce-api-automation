package OCC.Utils;

import OCC.DTOs.LoginPageRequestDTO;
import OCC.DTOs.CmsPageContentRequestDTO;
import OCC.DTOs.ProductCategorySearchPageRequestDTO;
import OCC.DTOs.StoreFinderSearchRequestDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIClient {

    public static Response getProduct(ProductCategorySearchPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/products/search");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response getOptionslist(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/password-reset/request-recovery-options");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response postPassword(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.post("/password-reset/request");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response getReceivedcode(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/password-reset/check-received-code");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response postChangePassword(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.post("/password-reset/change");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response getStores(StoreFinderSearchRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/stores");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response getHomepage(CmsPageContentRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/cms/pages/homepageHeadless");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }
}
