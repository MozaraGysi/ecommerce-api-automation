package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.UserResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class UserValidator implements Validator {

    @Override
    public boolean validate(Response response) {

        UserResponseDTO userResponseDTO = new UserResponseDTO().fromJsonString(response.getBody().asString());
        Assertions.assertNotNull(userResponseDTO.getUid());
        Assertions.assertNotNull(userResponseDTO.getFirstName());
        Assertions.assertNotNull(userResponseDTO.getLastName());
        Assertions.assertNotNull(userResponseDTO.getMobilePhone());
        Assertions.assertNotNull(userResponseDTO.getBirthday());
        Assertions.assertNotNull(userResponseDTO.getCpf());
        Assertions.assertNotNull(userResponseDTO.getPassword());
        Assertions.assertNotNull(userResponseDTO.getGenderCode());

        return true;
    }
}
