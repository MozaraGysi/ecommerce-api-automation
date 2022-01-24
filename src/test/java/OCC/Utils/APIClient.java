package OCC.Utils;

import OCC.DTOs.ProductCategorySearchPageRequestDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

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
}