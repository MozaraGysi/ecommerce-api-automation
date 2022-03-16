package OCC.Services;

import Common.Validators.StatusCodeBadRequestValidator;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.LoginPageRequestDTO;
import OCC.Fixtures.LoginPageRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.RecoverOptionEmailValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class LoginService {

    public static void getSearchOptionsListByEmail() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultRequestByEmail().build();

        Response response = APIClient.getOptionslist(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new RecoverOptionEmailValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void getSearchOptionsListByWrongEmail() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultRequestByWrongEmail().build();

        Response response = APIClient.getOptionslist(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void postRequestPasswordChangeByOption() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultPasswordOptionRequestByEmail().build();

        Response response = APIClient.postPassword(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void postRequestPasswordChangeByWrongOption() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultPasswordOptionRequestByWrongEmail().build();

        Response response = APIClient.postPassword(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void getRequestCheckReceivedCode() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultRequestByWrongCode().build();

        Response response = APIClient.getReceivedcode(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void postRequestChangePassword() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultRequestByWrongToken().build();

        Response response = APIClient.postChangePassword(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }
}
