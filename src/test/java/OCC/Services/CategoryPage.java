package OCC.Services;

import AutomationUtils.Validator;
import OCC.Utils.Utils;
import OCC.Validators.ValidacaoImages;
import OCC.Validators.ValidacaoName;
import OCC.Validators.ValidacaoValue;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class CategoryPage {

    public static void GET_searchName() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/arezzocoocc/v2/"+Utils.getSite_UID()+"/products/search?fields=FULL&query=3510500180001U&currentPage=0");
        List<Validator> validators = Arrays.asList(new ValidacaoName());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
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
        List<Validator> validators = Arrays.asList(new ValidacaoValue());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
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
        List<Validator> validators = Arrays.asList(new ValidacaoImages());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

}
