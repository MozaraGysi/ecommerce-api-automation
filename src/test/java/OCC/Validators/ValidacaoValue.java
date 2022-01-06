package OCC.Validators;

import AutomationUtils.Validator;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ValidacaoValue implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {
        ArrayList productValueList = response.jsonPath().get("products.price.value");
        int indexOfList = productValueList.size();
        boolean result = (!productValueList.get(indexOfList-1).toString().isEmpty());
        return result;
        }
    }
