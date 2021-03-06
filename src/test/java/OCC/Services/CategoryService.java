package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.ProductCategorySearchPageRequestDTO;
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

    public static void getSearchProductsByCode() {

        ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO =  ProductCategorySearchPageRequestDTOFixture.get().defaultRequestByCode().build();

        Response response = APIClient.getProduct(productCategorySearchPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new ProductNameValidator(), new ProductValueValidator(), new ProductImagesValidator());
        validators.stream().forEach(validator -> validator.validate(response));
    }

    public static void getSearchProductsByCodeFieldsAndPage(String code, String fields, String page) {

        ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO =  ProductCategorySearchPageRequestDTOFixture
                .get()
                .withQuery(code)
                .withCurrentPage(page)
                .withFields(fields)
                .build();

        Response response = APIClient.getProduct(productCategorySearchPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new ProductNameValidator(), new ProductValueValidator(), new ProductImagesValidator());
        validators.stream().forEach(validator -> validator.validate(response));
    }

    public static void getSearchProductsWithoutFilters() {

        ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO = ProductCategorySearchPageRequestDTOFixture.get().defaultRequestFull().build();

        Response response = APIClient.getProduct(productCategorySearchPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new ProductImagesValidator(), new ProductValueValidator());
        validators.stream().forEach(validator -> validator.validate(response));

    }

}
