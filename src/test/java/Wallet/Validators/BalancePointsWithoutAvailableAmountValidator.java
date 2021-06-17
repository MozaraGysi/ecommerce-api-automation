package Wallet.Validators;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class BalancePointsWithoutAvailableAmountValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		JsonObject responseBody = new Gson().fromJson(response.getBody().asString(), JsonObject.class);
		Assertions.assertEquals(0, responseBody.get("amount").getAsJsonObject().get("available").getAsDouble());

		return true;
	}
}



