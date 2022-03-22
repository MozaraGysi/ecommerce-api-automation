package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.AuthorizationResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class AnonymousAuthorizationValidator implements Validator {

    @Override
    public boolean validate(Response response) {
        AuthorizationResponseDTO authorizationResponseDTO = new AuthorizationResponseDTO().fromJsonString(response.getBody().asString());
        Assertions.assertNotNull(authorizationResponseDTO.getAccessToken());
        Assertions.assertNotNull(authorizationResponseDTO.getTokenType());
        Assertions.assertNotNull(authorizationResponseDTO.getExpiresIn());
        Assertions.assertNotNull(authorizationResponseDTO.getScope());

        return true;
    }
}
