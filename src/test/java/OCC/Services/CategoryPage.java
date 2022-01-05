package OCC.Services;

import OCC.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;


public class CategoryPage {

    public static void GET_searchName() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/arezzocoocc/v2/"+Utils.getSite_UID()+"/products/search?fields=FULL&query=3510500180001U&currentPage=0");
        ArrayList productNameList = response.jsonPath().get("products.name");
        int indexOfList = productNameList.size();
        productNameList.get(indexOfList-1).toString().contains("DORA JEANS VENICE NIGHT SHADE");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_searchValue() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/arezzocoocc/v2/"+Utils.getSite_UID()+"/products/search?fields=FULL&query=3510500180001U&currentPage=0");
        ArrayList productValueList = response.jsonPath().get("products.price.value");
        int indexOfList = productValueList.size();
        Assertions.assertTrue(!productValueList.get(indexOfList-1).toString().isEmpty());
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_searchImages(){
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/arezzocoocc/v2/"+Utils.getSite_UID()+"/products/search?fields=FULL&currentPage=0");
        ArrayList productImagesList = response.jsonPath().get("products.images.url");
        int indexOfList = productImagesList.size();
        Assertions.assertTrue(!productImagesList.get(indexOfList-1).toString().isEmpty());
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

}
