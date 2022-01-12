package OCC.Validators;

import Common.Validators.Validator;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ValidacaoImages implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        ArrayList productImagesList = response.jsonPath().get("products.images.url");
        int indexOfList = productImagesList.size();
        Assertions.assertTrue(!productImagesList.get(indexOfList - 1).toString().isEmpty());
        return true;
    }
}
