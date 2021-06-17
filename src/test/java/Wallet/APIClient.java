package Wallet;

import Wallet.Utils.Utils;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIClient {

	public static Response POST_customers(JsonObject requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toString());

		Response response = request.post("/customers");
		response.getBody().print();

		return response;
	}

	public static Response GET_balancePoints(String document) {
		RestAssured.baseURI = Utils.getBaseUrl();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/" + document + "/balance-points");
		response.getBody().print();

		return response;
	}

	public static Response GET_points(String document) {
		RestAssured.baseURI = Utils.getBaseUrl();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/" + document + "/points");
		response.getBody().print();

		return response;
	}

	public static Response POST_creditPoints(JsonObject requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toString());

		Response response = request.post("/customers/credit-points");
		response.getBody().print();

		return response;
	}
}
