package Wallet.Validators;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

public class StatusCodeCreatedValidator implements Validator {
	@Override
	public boolean validate(Response response) {
		Assertions.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());

		return true;
	}
}
