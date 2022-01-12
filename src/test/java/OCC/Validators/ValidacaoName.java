package OCC.Validators;

import Common.Validators.Validator;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ValidacaoName implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {
        ArrayList productNameList = response.jsonPath().get("products.name");
        int indexOfList = productNameList.size();
        Assertions.assertTrue(productNameList.get(indexOfList-1).toString().contains("DORA JEANS VENICE NIGHT SHADE"));
        return true;
    }
}
