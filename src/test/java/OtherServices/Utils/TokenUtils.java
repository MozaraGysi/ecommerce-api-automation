package OtherServices.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;



public class TokenUtils {
    public static String ClientToken()
    {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "arezzoco_ws");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "client_credentials");
        request.formParam("site_uid", "arezzo");

        Response response = request.post("arezzocows/oauth/v3/token");

        Assertions.assertEquals(200, response.getStatusCode());

        return response.jsonPath().get("access_token");
    }
}
