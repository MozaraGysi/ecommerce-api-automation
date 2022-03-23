package OCC.Services;

import Common.Validators.StatusCodeCreatedValidator;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.AddressRequestDTO;
import OCC.DTOs.Request.UserRequestDTO;
import OCC.Fixtures.AddressRequestDTOFixture;
import OCC.Fixtures.UserRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class UsersService {

    public static void Users() {

        UserRequestDTO userRequestDTO = UserRequestDTOFixture.getRandom().build();
        Response response = APIClient.postRegisterNewUser(userRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new UserValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

    public static void postAddresses() {

        AddressRequestDTO addressRequestDTO = AddressRequestDTOFixture.get().addressRS().build();
        Response response = APIClient.postAddresses(addressRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new AddressValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

    public static void getAddresses() {

        AddressRequestDTO addressRequestDTO = AddressRequestDTOFixture.get().addressRS().build();
        Response response = APIClient.getAddresses(addressRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new AddressValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

    public static void patchUser() {

        UserRequestDTO userRequestDTO = UserRequestDTOFixture.getRandom().build();
        Response response = APIClient.patchUser(userRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new UserValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

}
