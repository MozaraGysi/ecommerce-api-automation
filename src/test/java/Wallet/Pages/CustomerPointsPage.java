package Wallet.Pages;

import Wallet.Utils.Utils;
import Wallet.Validators.Validator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class CustomerPointsPage {
	public static void getBalance(Validator...validators) {
		RestAssured.baseURI = Utils.getBaseUrl();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());

		Response response = request.get("/customers/" + Utils.getCPF() + "/balance-points");

		Assertions.assertTrue(Arrays.stream(validators).allMatch(validator -> validator.validate(response)));
	}
}
