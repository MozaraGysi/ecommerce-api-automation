package Wallet.Pages;

import Wallet.Utils.Utils;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class CustomerPage {

	public static void newUser() {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(getBodyJsonNewUser().toString());
		Response response = request.post("/customers");
		Assertions.assertEquals(201, response.getStatusCode());
	}

	public static JsonObject getBodyJsonNewUser() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("document", Utils.getCPF());
		jsonObject.addProperty("firstName", "Douglas");
		jsonObject.addProperty("lastName", "Golke");
		jsonObject.addProperty("birthday", "2000-01-22");
		jsonObject.addProperty("email", Utils.getEMAIL());
		jsonObject.addProperty("mobile", "5552998288513");
		return jsonObject;
	}
}
