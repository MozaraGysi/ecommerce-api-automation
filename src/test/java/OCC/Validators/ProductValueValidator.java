package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.ProductCategorySearchPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import static org.junit.jupiter.api.Assertions.*;

public class ProductValueValidator implements Validator {
    @Override
    public void validate(@NotNull Response response) {

        ProductCategorySearchPageResponseDTO productCategorySearchPageResponseDTO = new ProductCategorySearchPageResponseDTO().fromJsonString(response.getBody().asString());

        productCategorySearchPageResponseDTO.getProducts().forEach(productDTO -> {
            assertNotNull(productDTO.getPrice().getValue());
        });
    }
}