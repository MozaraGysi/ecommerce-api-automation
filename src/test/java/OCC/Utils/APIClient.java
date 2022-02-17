package OCC.Utils;

import OCC.DTOs.LoginPageRequestDTO;
import OCC.DTOs.CmsPageContentRequestDTO;
import OCC.DTOs.ProductCategorySearchPageRequestDTO;
import OCC.DTOs.StoreFinderSearchRequestDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIClient {

    public static Response GET_product(ProductCategorySearchPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/arezzocoocc/v2/" + Utils.getSite_UID() + "/products/search");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response GET_optionslist(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/arezzocoocc/v2/" + Utils.getSite_UID() + "/password-reset/request-recovery-options");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response POST_password(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.post("/arezzocoocc/v2/" + Utils.getSite_UID() + "/password-reset/request");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response GET_receivdcode(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/arezzocoocc/v2/" + Utils.getSite_UID() + "/password-reset/check-received-code");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response POST_changepassword(LoginPageRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.post("/arezzocoocc/v2/" + Utils.getSite_UID() + "/password-reset/change");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response GET_stores(StoreFinderSearchRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/arezzocoocc/v2/" + Utils.getSite_UID() + "/stores");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }

    public static Response GET_homepage(CmsPageContentRequestDTO requestDTO) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/arezzocoocc/v2/" + Utils.getSite_UID() + "/cms/pages/homepageHeadless");

        response.getBody().print();
        Utils.setCookies(response.getCookies());

        return response;
    }
}
