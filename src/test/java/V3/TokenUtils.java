package V3;

import V3.APIHandle.ValidateAuthorization;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;


public class TokenUtils {

    public static String GetCustomerToken() {
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
        Assertions.assertEquals(200, response.getStatusCode());
        String token = response.jsonPath().get("access_token");
        ResponseBody body = response.getBody();
        ValidateAuthorization.CustomerAuthorizationValidation(body.prettyPrint());

        return token;
    }
}
