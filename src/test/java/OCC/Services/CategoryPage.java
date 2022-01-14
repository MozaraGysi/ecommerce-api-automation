package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.ProductCategorySearchPageRequestDTO;
import OCC.Utils.APIClient;
import OCC.Utils.Utils;
import OCC.Validators.ProductImagesValidator;
import OCC.Validators.ProductNameValidator;
import OCC.Validators.ProductValueValidator;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class CategoryPage {

    public static void GET_searchProductsByCode() {
        ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO = new ProductCategorySearchPageRequestDTO();
        productCategorySearchPageRequestDTO.setFields("FULL");
        productCategorySearchPageRequestDTO.setQuery("3510500180001U");
        productCategorySearchPageRequestDTO.setCurrentPage("0");

        Response response = APIClient.GET_product(productCategorySearchPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new ProductNameValidator(), new ProductValueValidator(), new ProductImagesValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_searchProductsWithoutFilters() {
        ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO = new ProductCategorySearchPageRequestDTO();
        productCategorySearchPageRequestDTO.setFields("FULL");
        productCategorySearchPageRequestDTO.setCurrentPage("0");

        Response response = APIClient.GET_product(productCategorySearchPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new ProductImagesValidator(), new ProductNameValidator(), new ProductValueValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

}
