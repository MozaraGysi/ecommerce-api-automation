package OCC.Services;

import Common.Validators.Validator;
import OCC.DTOs.AuthorizationResponseDTO;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.Utils;
import OCC.Validators.AnonymousAuthorizationValidator;
import OCC.Validators.StatusCodeResponseValidator;
import OCC.Validators.CustomerAuthorizationValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class AuthorizationService {

    public static void CustomerToken()
    {
        RestAssured.baseURI = Utils.getBaseUrl(true);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("scope", "basic");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "password");
        request.formParam("username","rrsetcwi@gmail.com");
        request.formParam("password","zero123@");
        request.formParam("site_uid", "marketplacezz");

        Response response = request.post("/arezzocoocc/oauth/token");
        validateAuthorizationResponse(request, response);
        handleAuthorization(response);

    }

    public static void CustomerTokenNewUser()
    {
        RestAssured.baseURI = Utils.getBaseUrl(true);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("scope", "basic");
        request.formParam("grant_type", "password");
        request.formParam("site_uid", Utils.getSite_UID());
        request.formParam("username",Utils.getEMAIL());
        request.formParam("password","zero123@");

        Response response = request.post("/arezzocoocc/oauth/token");
        validateAuthorizationResponse(request, response);
        handleAuthorization(response);
    }

    public static void AnonymousAuth()
    {
        RestAssured.baseURI = Utils.getBaseUrl(true);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("scope", "basic");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "client_credentials");

        Response response = request.post("/arezzocoocc/oauth/token");
        validateAuthorizationResponse(request, response);
        handleAuthorization(response);
    }

    public static void RegisterCustomerAppleID()
    {
        RestAssured.baseURI = Utils.getBaseUrl(true);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("scope", "basic");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "apple_id");
        request.formParam("username","leonardotst01@outstore.com");
        request.formParam("userAppleId", "123456789");
        request.formParam("firstName", "Leonardo");
        request.formParam("lastName", "Wille");
        request.formParam("site_uid", Utils.getSite_UID());

        Response response = request.post("/arezzocoocc/oauth/token");
        validateAuthorizationResponse(request, response);
        handleAuthorization(response);
    }

    public static void RegisterCustomerFacebook()
    {
        RestAssured.baseURI = Utils.getBaseUrl(true);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("scope", "basic");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "facebook");
        request.formParam("facebook_token", "EAANWNiebQQABAGH1O4tp3CjR8ckjSsmcQSKzWyUhwZCca2W1d47hsY4ZBmad4DDMgHjjOE8znFT9nCaSHi2Gw3qb44KBQ1fUl9mv7suhzZBo916Ylp7U3aBe30sjz0IgVHOwc9ZApHfdWN1oHYCK5uNiTEZCnLSZCBUY13oo9gSzpMZAVKpZC3qOzQMqxGkmMeAPHWBqUT43LfNNZAbX7HtcZC");
        request.formParam("site_uid", Utils.getSite_UID());

        Response response = request.post("/arezzocoocc/oauth/token");
        validateAuthorizationResponse(request, response);
        handleAuthorization(response);
    }

    private static void handleAuthorization(Response response) {
        AuthorizationResponseDTO authorizationResponseDTO = new AuthorizationResponseDTO().fromJsonString(response.getBody().asString());
        authorizationResponseDTO.setCookies(response.getCookies());
        AuthorizationHandler.addAuthorization(authorizationResponseDTO);
    }

    private static void validateAuthorizationResponse(RequestSpecification request, Response response) {
        if (Utils.isAnonymousUser(request)) {
            List<Validator> validators = Arrays.asList(new StatusCodeResponseValidator(), new AnonymousAuthorizationValidator());
            Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
        } else {
            List<Validator> validators = Arrays.asList(new StatusCodeResponseValidator(), new CustomerAuthorizationValidator());
            Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
        }

    }
}
