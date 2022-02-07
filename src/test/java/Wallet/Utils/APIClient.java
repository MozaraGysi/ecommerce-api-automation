package Wallet.Utils;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIClient {

	public static Response postCustomers(JsonObject requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toString());

		Response response = request.post("/customers");
		response.getBody().print();

		return response;
	}

	public static Response getBalancePoints(String document) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/" + document + "/balance-points");
		response.getBody().print();

		return response;
	}

	public static Response getPoints(String document) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/" + document + "/points");
		response.getBody().print();

		return response;
	}

	public static Response postCreditPoints(JsonObject requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toString());

		Response response = request.post("/customers/credit-points");
		response.getBody().print();

		return response;
	}

	public static Response deleteCreditPoints(JsonObject requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toString());

		Response response = request.delete("/customers/credit-points");
		response.getBody().print();

		return response;
	}

	public static Response getCreditTransactions(String transactionId) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/credit-transactions/" + transactionId);
		response.getBody().print();

		return response;
	}

	public static Response postDebitPoints(JsonObject requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toString());

		Response response = request.post("/customers/debit-points");
		response.getBody().print();

		return response;
	}

	public static Response deleteDebitPoints(JsonObject requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toString());

		Response response = request.delete("/customers/debit-points");
		response.getBody().print();

		return response;
	}

	public static Response getExpirePoints(String expireAt) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/expire-points?expire-at=" + expireAt);
		response.getBody().print();

		return response;
	}
}
