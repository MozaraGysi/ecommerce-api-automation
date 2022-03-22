package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.AddressRequestDTO;
import OCC.DTOs.Request.UserRequestDTO;
import OCC.Fixtures.AddressRequestDTOFixture;
import OCC.Fixtures.UserRequestDTOFixture;
import OCC.Fixtures.UserRegisterRequestDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.APIClient;
import OCC.Utils.Utils;
import OCC.Validators.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class UsersService {

    public static void Users() {

        UserRequestDTO userRequestDTO = UserRequestDTOFixture.getRandom().build();
        Response response = APIClient.postRegisterNewUser(userRequestDTO);
        List<Validator> validators = Arrays.asList(new UsersValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

    public static void postAddresses() {

        AddressRequestDTO addressRequestDTO = AddressRequestDTOFixture.get().addressRS().build();
        Response response = APIClient.postAddresses(addressRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

    public static void getAddresses() {

        Response response = APIClient.getAddresses();
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

    public static void patchUser() {

        UserRequestDTO userRequestDTO = UserRequestDTOFixture.getRandom().build();
        Response response = APIClient.patchUser(userRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

}
