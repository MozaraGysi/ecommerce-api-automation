package SuperApp;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;


public class Utils {
    URLSetter url = new URLSetter();

    public String GetToken() {
        RestAssured.baseURI = url.SetterURL();
        RequestSpecification request = RestAssured.given();

        final JsonObject requestParams = new JsonObject();

        request.formParam("scope", "basic");
        request.formParam("grant_type", "password");
        request.formParam("username", "#schbr_anajulia@schutz.com");
        request.formParam("password", "abc123");


        request.body(requestParams.toString());
        Response response = request.post("/arezzocoocc/oauth/token");

        Assert.assertEquals(response.getStatusCode(), 200);


        return response.toString();
    }
}
