package OCC;

import V3.APIHandle.ValidateAuthorization;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class Utils {

    public String GetCustomerToken() {
        RestAssured.baseURI = OCC.URLSetter.SetterURL();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "mobile_android");
        request.formParam("scope", "basic");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "password");
        request.formParam("username","ter_hsaueressig@arezzo.com.br");
        request.formParam("password","Arezzo123");
        request.formParam("site_uid", "marketplacezz");

        Response response = request.post("oauth/token");
        Assert.assertEquals(200, response.getStatusCode());
        String token = response.jsonPath().get("access_token");
        ResponseBody body = response.getBody();

        return token;
    }
}
