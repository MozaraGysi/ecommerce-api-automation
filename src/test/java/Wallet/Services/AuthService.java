package Wallet.Services;

import Wallet.Utils.Utils;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;

import java.util.Collections;

public class AuthService {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_TYPE_BASIC = "Basic ";

	private static HttpHeaders getDefaultHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return headers;
	}

	private static HttpHeaders getDefaultHeadersWithBasicAuthorization() {
		HttpHeaders headers = getDefaultHeaders();

		final String authorization = Utils.getCredentials();
		final String authorizationBase64 = Base64Utils.encodeToString(authorization.getBytes());

		headers.add(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_TYPE_BASIC + authorizationBase64);

		return headers;
	}

	public static void getToken() {
		RestAssured.baseURI = Utils.getBaseAuthUrl();

		RequestSpecification request = RestAssured.given();
		request.headers(getDefaultHeadersWithBasicAuthorization());
		request.body(getBodyJsonBasicAuth().toString());
		Response response = request.post("/access-token");

		response.getBody().prettyPrint();

		Assertions.assertEquals(200, response.getStatusCode());
		Utils.setACCESS_TOKEN(response.body().jsonPath().get("access_token"));
	}

	private static JsonObject getBodyJsonBasicAuth() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("grant_type", "client_credentials");
		return jsonObject;
	}
}
