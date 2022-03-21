package OCC.Services;

import OCC.Handlers.*;
import OCC.Utils.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
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
        Assertions.assertEquals(200, response.getStatusCode());
        Utils.setCookies(response.getCookies());
        Utils.setAccessToken(response.body().jsonPath().get("access_token"));
        ResponseBody body = response.getBody();
        AuthorizationValidation.CustomerAuthValidation(body.asString());
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
        request.formParam("site_uid", Utils.getSiteUid());
        request.formParam("username",Utils.getEmail());
        request.formParam("password","zero123@");

        Response response = request.post("/arezzocoocc/oauth/token");
        Assertions.assertEquals(200, response.getStatusCode());
        Utils.setCookies(response.getCookies());
        Utils.setAccessToken(response.body().jsonPath().get("access_token"));
        AuthorizationValidation.CustomerAuthValidation(response.body().asString());
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
        Assertions.assertEquals(200, response.getStatusCode());
        Utils.setCookies(response.getCookies());
        ResponseBody body = response.getBody();
        AuthorizationValidation.AnonymousAuthValdiation(body.asString());
        Utils.setAccessToken(body.jsonPath().get("access_token"));
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
        request.formParam("site_uid", Utils.getSiteUid());

        Response response = request.post("/arezzocoocc/oauth/token");
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();
        AuthorizationValidation.RegisterCustomerAppleIDValidation(body.prettyPrint());
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
        request.formParam("site_uid", Utils.getSiteUid());

        Response response = request.post("/arezzocoocc/oauth/token");
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();
        AuthorizationValidation.RegisterCustomerFacebookValidation(body.prettyPrint());
    }
}
