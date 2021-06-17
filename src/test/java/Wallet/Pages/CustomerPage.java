package Wallet.Pages;

import Wallet.APIClient;
import Wallet.Utils.Utils;
import Wallet.Validators.StatusCodeCreatedValidator;
import Wallet.Validators.Validator;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CustomerPage {

	public static void newUser() {
		Response response = APIClient.POST_customers(getBodyJsonNewUser());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
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
