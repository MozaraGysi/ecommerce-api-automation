package Wallet.Pages;

import Wallet.APIClient;
import Wallet.Fixtures.CustomerFixture;
import Wallet.Validators.StatusCodeCreatedValidator;
import Wallet.Validators.Validator;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CustomerPage {

	public static void newUser() {
		JsonObject requestBody = CustomerFixture.build();

		Response response = APIClient.POST_customers(requestBody);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutCPF() {
		JsonObject requestBody = CustomerFixture.build();
		requestBody.remove("document");

		Response response = APIClient.POST_customers(requestBody);

		List<Validator> validators = Arrays.asList();
		// TODO: Add after remove API mocks
		//new StatusCodeBadRequestValidator();
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutFirstName() {
		JsonObject requestBody = CustomerFixture.build();
		requestBody.remove("firstName");

		Response response = APIClient.POST_customers(requestBody);

		List<Validator> validators = Arrays.asList();
		// TODO: Add after remove API mocks
		//new StatusCodeBadRequestValidator();
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutLastName() {
		JsonObject requestBody = CustomerFixture.build();
		requestBody.remove("lastName");

		Response response = APIClient.POST_customers(requestBody);

		List<Validator> validators = Arrays.asList();
		// TODO: Add after remove API mocks
		//new StatusCodeBadRequestValidator();
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
