package OCC.Utils;

import OCC.Utils.Utils;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIClient {

    public static Response GET_product(String document) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        Response response = request.get("/arezzocoocc/v2/" + document + "/products/search?fields=FULL&query=3510500180001U&currentPage=0");
        response.getBody().print();

        return response;
    }

    public static Response GET_productFull(String document) {
        RestAssured.baseURI = OCC.Utils.Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        Response response = request.get("/arezzocoocc/v2/" + document + "/products/search?fields=FULL&currentPage=0");
        response.getBody().print();

        return response;
    }
}
