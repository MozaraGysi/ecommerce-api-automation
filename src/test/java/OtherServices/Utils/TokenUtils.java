package OtherServices.Utils;

import OtherServices.Data.DataTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class TokenUtils {

	private static final String CONTENT_TYPE_HEADER = "Content-Type";
	private static final String AUTHORIZATION_FORM_CLIENT_ID = "client_id";
	private static final String AUTHORIZATION_FORM_CLIENT_SECRET = "client_secret";
	private static final String AUTHORIZATION_FORM_GRANT_TYPE = "grant_type";
	private static final String AUTHORIZATION_FORM_SITE_UID = "site_uid";

	public static String ClientToken() {
		RestAssured.baseURI = DataTest.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header(CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
		request.formParam(AUTHORIZATION_FORM_CLIENT_ID, "arezzoco_ws");
		request.formParam(AUTHORIZATION_FORM_CLIENT_SECRET, "arezzoco2014");
		request.formParam(AUTHORIZATION_FORM_GRANT_TYPE, "client_credentials");
		request.formParam(AUTHORIZATION_FORM_SITE_UID, "arezzo");

		Response response = request.post("arezzocows/oauth/v3/token");

		Assertions.assertEquals(200, response.getStatusCode());

		return response.jsonPath().get("access_token");
	}
}
