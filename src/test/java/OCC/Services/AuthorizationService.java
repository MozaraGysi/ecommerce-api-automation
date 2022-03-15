package OCC.Services;

import OCC.DTOs.AuthResponseDTO;
import OCC.Utils.Utils;
import OCC.Validators.AnonymousAuthValidator;
import OCC.Validators.AppleAuthValidator;
import OCC.Validators.CustomerAuthValidator;
import OCC.Validators.FacebookAuthValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

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
        Assertions.assertTrue(new CustomerAuthValidator().validate(response));

        AuthResponseDTO authResponseDTO = new AuthResponseDTO().fromJsonString(response.getBody().asString());

        Utils.setCookies(response.getCookies());
        Utils.setACCESS_TOKEN(authResponseDTO.getAccessToken());

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
        Assertions.assertTrue(new CustomerAuthValidator().validate(response));

        AuthResponseDTO authResponseDTO = new AuthResponseDTO().fromJsonString(response.getBody().asString());

        Utils.setCookies(response.getCookies());
        Utils.setACCESS_TOKEN(authResponseDTO.getAccessToken());
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
        Assertions.assertTrue(new AnonymousAuthValidator().validate(response));

        AuthResponseDTO authResponseDTO = new AuthResponseDTO().fromJsonString(response.getBody().asString());

        Utils.setCookies(response.getCookies());
        Utils.setACCESS_TOKEN(authResponseDTO.getAccessToken());
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
        Assertions.assertTrue(new AppleAuthValidator().validate(response));

        AuthResponseDTO authResponseDTO = new AuthResponseDTO().fromJsonString(response.getBody().asString());

        Utils.setCookies(response.getCookies());
        Utils.setACCESS_TOKEN(authResponseDTO.getAccessToken());
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
        Assertions.assertTrue(new FacebookAuthValidator().validate(response));

        AuthResponseDTO authResponseDTO = new AuthResponseDTO().fromJsonString(response.getBody().asString());

        Utils.setCookies(response.getCookies());
        Utils.setACCESS_TOKEN(authResponseDTO.getAccessToken());
    }
}
