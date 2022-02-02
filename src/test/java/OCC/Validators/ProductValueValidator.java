package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.ProductCategorySearchPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class ProductValueValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        ProductCategorySearchPageResponseDTO productCategorySearchPageResponseDTO = new ProductCategorySearchPageResponseDTO().fromJsonString(response.getBody().asString());

        productCategorySearchPageResponseDTO.getProducts().forEach(productDTO -> {
            Assertions.assertNotNull(productDTO.getPrice().getValue());
        });
        return true;
    }
}