package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.UserResponseDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidator implements Validator {

    @Override
    public void validate(Response response) {

        UserResponseDTO userResponseDTO = new UserResponseDTO().fromJsonString(response.getBody().asString());
        assertNotNull(userResponseDTO.getUid());
        assertNotNull(userResponseDTO.getFirstName());
        assertNotNull(userResponseDTO.getLastName());
        assertNotNull(userResponseDTO.getMobilePhone());
        assertNotNull(userResponseDTO.getBirthday());
        assertNotNull(userResponseDTO.getCpf());
        assertNotNull(userResponseDTO.getPassword());
        assertNotNull(userResponseDTO.getGenderCode());

    }
}
