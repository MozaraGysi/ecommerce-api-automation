package OCC.Validators;

import Common.Validators.Validator;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ValidacaoValue implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {
        ArrayList productValueList = response.jsonPath().get("products.price.value");
        int indexOfList = productValueList.size();
        Assertions.assertTrue((!productValueList.get(indexOfList-1).toString().isEmpty()));
        return true;
        }
    }
