package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.ProductCategorySearchPageRequestDTO;
import OCC.Fixtures.ProductCategorySearchPageRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.ProductImagesValidator;
import OCC.Validators.ProductNameValidator;
import OCC.Validators.ProductValueValidator;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class CategoryService {

    public static void GET_searchProductsByCode() {

        ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO =  new ProductCategorySearchPageRequestDTOFixture().defaultRequestByCode().build();

        Response response = APIClient.GET_product(productCategorySearchPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new ProductNameValidator(), new ProductValueValidator(), new ProductImagesValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_searchProductsWithoutFilters() {

        ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO = new ProductCategorySearchPageRequestDTOFixture().defaultRequestFull().build();

        Response response = APIClient.GET_product(productCategorySearchPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new ProductImagesValidator(), new ProductValueValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

}
