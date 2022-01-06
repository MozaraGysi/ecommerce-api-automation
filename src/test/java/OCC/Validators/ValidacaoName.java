package OCC.Validators;

import AutomationUtils.Validator;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ValidacaoName implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {
        ArrayList productNameList = response.jsonPath().get("products.name");
        int indexOfList = productNameList.size();
        boolean result =  productNameList.get(indexOfList-1).toString().contains("DORA JEANS VENICE NIGHT SHADE");
        return result;
    }
}
