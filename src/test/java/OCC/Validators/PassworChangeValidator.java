package OCC.Validators;

import Common.Validators.Validator;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

public class PassworChangeValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {
        return true;
    }
}
