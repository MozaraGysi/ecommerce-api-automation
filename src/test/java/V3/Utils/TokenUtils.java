package V3.Utils;

import V3.Handlers.ValidateAuthorization;
import V3.Data.DataTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class TokenUtils {

    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String AUTHORIZATION_FORM_CLIENT_ID = "client_id";
    private static final String AUTHORIZATION_FORM_CLIENT_SECRET = "client_secret";
    private static final String AUTHORIZATION_FORM_GRANT_TYPE = "grant_type";
    private static final String AUTHORIZATION_FORM_SITE_UID = "site_uid";
    private static final String AUTHORIZATION_FORM_USERNAME = "username";
    private static final String AUTHORIZATION_FORM_PASSWORD = "password";

    public static String getCustomerToken() {
        RestAssured.baseURI = DataTest.getWebServiceUrl();

        RequestSpecification request = RestAssured.given();
        request.header(CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
        request.formParam(AUTHORIZATION_FORM_CLIENT_ID, "arezzoco_ws");
        request.formParam(AUTHORIZATION_FORM_CLIENT_SECRET, "arezzoco2014");
        request.formParam(AUTHORIZATION_FORM_GRANT_TYPE, "password");
        request.formParam(AUTHORIZATION_FORM_USERNAME,"testeabcd4@tst.com.br");
        request.formParam(AUTHORIZATION_FORM_PASSWORD,"Zero@@123");
        request.formParam(AUTHORIZATION_FORM_SITE_UID, "arezzo");

        Response response = request.post("oauth/v3/token");
        Assertions.assertEquals(200, response.getStatusCode());
        String token = response.jsonPath().get("access_token");
        ResponseBody body = response.getBody();
        ValidateAuthorization.CustomerAuthorizationValidation(body.prettyPrint());

        return token;
    }
}
