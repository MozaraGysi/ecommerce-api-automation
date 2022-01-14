package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.ProductCategorySearchPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ProductNameValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        ProductCategorySearchPageResponseDTO productCategorySearchPageResponseDTO = new ProductCategorySearchPageResponseDTO().fromJsonString(response.getBody().asString());

        Assertions.assertTrue(productCategorySearchPageResponseDTO.getProducts().get(0).getName().contains("DORA JEANS VENICE NIGHT SHADE"));
        return true;
    }
}
