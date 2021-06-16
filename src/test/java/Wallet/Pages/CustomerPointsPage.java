package Wallet.Pages;

import Wallet.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class CustomerPointsPage {
	public static void getBalance() {
		RestAssured.baseURI = Utils.getBaseUrl();

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
		Response response = request.get("/customers/" + Utils.getCPF() + "/balance-points");
		Assertions.assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().toString());
	}
}
