package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.AuthResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class FacebookAuthValidator implements Validator {

    @Override
    public boolean validate(Response response) {
        Assertions.assertEquals(200, response.getStatusCode());

        AuthResponseDTO authResponseDTO = new AuthResponseDTO().fromJsonString(response.getBody().asString());
        Assertions.assertNotNull(authResponseDTO.getAccessToken());
        Assertions.assertNotNull(authResponseDTO.getTokenType());
        Assertions.assertNotNull(authResponseDTO.getRefreshToken());
        Assertions.assertNotNull(authResponseDTO.getExpiresIn());
        Assertions.assertNotNull(authResponseDTO.getScope());

        return true;
    }
}
