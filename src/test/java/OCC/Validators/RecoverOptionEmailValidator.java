package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.LoginPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class RecoverOptionEmailValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        LoginPageResponseDTO loginPageResponseDTO = new LoginPageResponseDTO().fromJsonString(response.getBody().asString());
        Assertions.assertTrue(loginPageResponseDTO.getRecoveryOptions().get(0).getCode().equals("EMAIL"));
        Assertions.assertTrue(loginPageResponseDTO.getRecoveryOptions().get(1).getCode().equals("SMS"));
        return true;
    }
}
