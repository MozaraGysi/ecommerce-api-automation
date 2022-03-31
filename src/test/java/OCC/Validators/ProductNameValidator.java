package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.ProductCategorySearchPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class ProductNameValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        ProductCategorySearchPageResponseDTO productCategorySearchPageResponseDTO = new ProductCategorySearchPageResponseDTO().fromJsonString(response.getBody().asString());

        Assertions.assertTrue(productCategorySearchPageResponseDTO.getProducts().get(0).getName().matches("[a-zA-Zà-úÀ-Ú0-9\\s]+"));
        return true;
    }
}
