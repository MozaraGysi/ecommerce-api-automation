package Wallet.Validators;

import AutomationUtils.Validator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

public class StatusCodeUnauthorizedValidator implements Validator {
	@Override
	public boolean validate(Response response) {
		Assertions.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatusCode());

		return true;
	}
}
