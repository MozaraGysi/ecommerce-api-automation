package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.Utils.APIClient;
import OCC.Utils.Utils;
import OCC.Validators.ValidacaoImages;
import OCC.Validators.ValidacaoName;
import OCC.Validators.ValidacaoValue;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class CategoryPage {

    public static void GET_searchName() {
        Response response = APIClient.GET_product(Utils.getSite_UID());
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(),new ValidacaoName());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void GET_searchValue() {
        Response response = APIClient.GET_product(Utils.getSite_UID());
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(),new ValidacaoValue());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
        Utils.setCookies(response.getCookies());
    }

    public static void GET_searchImages(){
        Response response = APIClient.GET_productFull(Utils.getSite_UID());
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(),new ValidacaoImages());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
        Utils.setCookies(response.getCookies());

    }

}
