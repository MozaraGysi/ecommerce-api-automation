package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.LoginPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import static org.junit.jupiter.api.Assertions.*;

public class RecoverOptionEmailValidator implements Validator {
    @Override
    public void validate(@NotNull Response response) {

        LoginPageResponseDTO loginPageResponseDTO = new LoginPageResponseDTO().fromJsonString(response.getBody().asString());
        assertTrue(loginPageResponseDTO.getRecoveryOptions().get(0).getCode().equals("SMS"));
        assertTrue(loginPageResponseDTO.getRecoveryOptions().get(1).getCode().equals("EMAIL"));
    }
}
