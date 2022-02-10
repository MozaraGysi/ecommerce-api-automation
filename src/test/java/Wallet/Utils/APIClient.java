package Wallet.Utils;

import Wallet.DTOs.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIClient {

	public static Response postCustomers(CustomerRequestDTO requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toJson().toString());

		Response response = request.post("/customers");
		response.getBody().print();

		return response;
	}

	public static Response getBalancePoints(String document) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/" + document + "/balance-points");
		response.getBody().print();

		return response;
	}

	public static Response getPoints(String document) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/" + document + "/points");
		response.getBody().print();

		return response;
	}

	public static Response postCreditPoints(CreditPointsRequestDTO requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toJson().toString());

		Response response = request.post("/customers/credit-points");
		response.getBody().print();

		return response;
	}

	public static Response deleteCreditPoints(DeleteCreditPointsRequestDTO requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toJson().toString());

		Response response = request.delete("/customers/credit-points");
		response.getBody().print();

		return response;
	}

	public static Response getCreditTransactions(String transactionId) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/credit-transactions/" + transactionId);
		response.getBody().print();

		return response;
	}

	public static Response postDebitPoints(DebitPointsRequestDTO requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toJson().toString());

		Response response = request.post("/customers/debit-points");
		response.getBody().print();

		return response;
	}

	public static Response deleteDebitPoints(DeleteDebitPointsRequestDTO requestBody) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		request.body(requestBody.toJson().toString());

		Response response = request.delete("/customers/debit-points");
		response.getBody().print();

		return response;
	}

	public static Response getExpirePoints(String expireAt) {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/expire-points?expire-at=" + expireAt);
		response.getBody().print();

		return response;
	}
}
