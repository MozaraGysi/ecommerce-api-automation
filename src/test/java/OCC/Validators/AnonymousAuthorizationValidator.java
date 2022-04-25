package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.AuthorizationResponseDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class AnonymousAuthorizationValidator implements Validator {

    @Override
    public void validate(Response response) {
        AuthorizationResponseDTO authorizationResponseDTO = new AuthorizationResponseDTO().fromJsonString(response.getBody().asString());
        assertNotNull(authorizationResponseDTO.getAccessToken());
        assertNotNull(authorizationResponseDTO.getTokenType());
        assertNotNull(authorizationResponseDTO.getExpiresIn());
        assertNotNull(authorizationResponseDTO.getScope());

    }
}
