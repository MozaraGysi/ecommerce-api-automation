package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.UserRequestDTO;
import OCC.Fixtures.AddressRequestDTOFixture;
import OCC.Fixtures.UserRequestDTOFixture;
import OCC.Fixtures.UserRegisterRequestDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.APIClient;
import OCC.Utils.Utils;
import OCC.Validators.StoreFinderValidator;
import OCC.Validators.UsersValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class UsersService {

    public static void Users() {

        UserRequestDTO userRequestDTO = UserRequestDTOFixture.getRandom().build();
        Response response = APIClient.postRegisterNewUser(userRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

    public static void postAddresses() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.body(AddressRequestDTOFixture.get().addressRS().build().toJson().toString());
        Response response = request.post("/users/current/addresses?fields=FULL");
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void getAddresses() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        Response response = request.get("/users/current/addresses?fields=FULL");
        Utils.setIdAddress(response.getBody().jsonPath().get("addresses.id"));
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void patchUser() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + AuthorizationHandler.getAuthorization().getAccessToken());
        request.header("Cookie", AuthorizationHandler.getAuthorization().getCookies());
        request.param("fields","FULL");
        request.body(UserRequestDTOFixture.get().addBirthday().addMobilePhone().addCpf().build().toJson().toString());
        Response response = request.patch("/users/current/?fields=FULL");
        response.print();
        AuthorizationHandler.getAuthorization().setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

}
