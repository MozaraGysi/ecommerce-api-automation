package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.ProductCategorySearchPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class ProductNameValidator implements Validator {
    @Override
    public void validate(@NotNull Response response) {

        ProductCategorySearchPageResponseDTO productCategorySearchPageResponseDTO = new ProductCategorySearchPageResponseDTO().fromJsonString(response.getBody().asString());

        Assertions.assertFalse(productCategorySearchPageResponseDTO.getProducts().get(0).getName().isEmpty());
    }
}
