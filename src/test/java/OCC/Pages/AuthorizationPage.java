package OCC.Pages;

import OCC.APIHandler.*;
import OCC.Utils.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class AuthorizationPage {


    public static void CustomerToken()
    {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("scope", "basic");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "password");
        request.formParam("username","ter_hsaueressig@arezzo.com.br");
        request.formParam("password","Arezzo123");
        request.formParam("site_uid", "marketplacezz");

        Response response = request.post("/arezzocoocc/oauth/token");
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();
        AuthorizationValidation.CustomerAuthValidation(body.prettyPrint());
    }

    public static void AnonymousAuth()
    {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("scope", "basic");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "client_credentials");
        Response response = request.post("/arezzocoocc/oauth/token");
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();
        AuthorizationValidation.AnonymousAuthValdiation(body.prettyPrint());
    }

    public static void RegisterCustomerAppleID()
    {
        RestAssured.baseURI = Utils.getBaseUrl();
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
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();
        AuthorizationValidation.RegisterCustomerAppleIDValidation(body.prettyPrint());
    }

    public static void RegisterCustomerFacebook()
    {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("scope", "basic");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "facebook");
        request.formParam("facebook_token", "EAANWNiebQQABAGH1O4tp3CjR8ckjSsmcQSKzWyUhwZCca2W1d47hsY4ZBmad4DDMgHjjOE8znFT9nCaSHi2Gw3qb44KBQ1fUl9mv7suhzZBo916Ylp7U3aBe30sjz0IgVHOwc9ZApHfdWN1oHYCK5uNiTEZCnLSZCBUY13oo9gSzpMZAVKpZC3qOzQMqxGkmMeAPHWBqUT43LfNNZAbX7HtcZC");
        request.formParam("site_uid", Utils.getSite_UID());

        Response response = request.post("/arezzocoocc/oauth/token");
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();
        AuthorizationValidation.RegisterCustomerFacebookValidation(body.prettyPrint());
    }
}
