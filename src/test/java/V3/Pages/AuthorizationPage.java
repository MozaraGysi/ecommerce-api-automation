package V3.Pages;

import V3.URLSetter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class AuthorizationPage {
    
    public static String CustomerToken() {
        RestAssured.baseURI = URLSetter.SetterURL();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "arezzoco_ws");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "password");
        request.formParam("username","testeabcd4@tst.com.br");
        request.formParam("password","Zero@@123");
        request.formParam("site_uid", "arezzo");

        Response response = request.post("oauth/v3/token");
        Assert.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();


        return body.prettyPrint();
    }
}
