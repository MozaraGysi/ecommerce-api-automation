package OCC.Services;

import Common.Validators.StatusCodeBadRequestValidator;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.LoginPageRequestDTO;
import OCC.Fixtures.LoginPageRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.RecoverOptionEmailValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class LoginService {

    public static void GET_searchOptionsListByEmail() {

        LoginPageRequestDTO loginPageRequestDTO = LoginPageRequestDTOFixture.get().defaultRequestByEmail().build();

        Response response = APIClient.GET_optionslist(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new RecoverOptionEmailValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_searchOptionsListByWrongEmail() {

        LoginPageRequestDTO loginPageRequestDTO = LoginPageRequestDTOFixture.get().defaultRequestByWrongEmail().build();

        Response response = APIClient.GET_optionslist(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void POST_RequestPasswordChangeByOption() {

        LoginPageRequestDTO loginPageRequestDTO = LoginPageRequestDTOFixture.get().defaultPasswordOptionRequestByEmail().build();

        Response response = APIClient.POST_password(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void POST_RequestPasswordChangeByWrongOption() {

        LoginPageRequestDTO loginPageRequestDTO = LoginPageRequestDTOFixture.get().defaultPasswordOptionRequestByWrongEmail().build();

        Response response = APIClient.POST_password(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_requestCheckReceivdCode() {

        LoginPageRequestDTO loginPageRequestDTO = LoginPageRequestDTOFixture.get().defaultRequestByWrongCode().build();

        Response response = APIClient.GET_receivdcode(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void POST_requestChangePassword() {

        LoginPageRequestDTO loginPageRequestDTO = LoginPageRequestDTOFixture.get().defaultRequestByWrongToken().build();

        Response response = APIClient.POST_changepassword(loginPageRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }
}
