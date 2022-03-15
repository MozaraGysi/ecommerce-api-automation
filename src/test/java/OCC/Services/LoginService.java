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

    public static void GET_searchOptionsListByEmail() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultRequestByEmail().build();

        Response response = APIClient.GET_optionslist(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new RecoverOptionEmailValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_searchOptionsListByWrongEmail() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultRequestByWrongEmail().build();

        Response response = APIClient.GET_optionslist(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void POST_RequestPasswordChangeByOption() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultPasswordOptionRequestByEmail().build();

        Response response = APIClient.POST_password(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void POST_RequestPasswordChangeByWrongOption() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultPasswordOptionRequestByWrongEmail().build();

        Response response = APIClient.POST_password(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_requestCheckReceivdCode() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultRequestByWrongCode().build();

        Response response = APIClient.GET_receivdcode(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void POST_requestChangePassword() {

        LoginPageRequestDTO loginPageRequestDTO = new LoginPageRequestDTOFixture().defaultRequestByWrongToken().build();

        Response response = APIClient.POST_changepassword(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }
}
