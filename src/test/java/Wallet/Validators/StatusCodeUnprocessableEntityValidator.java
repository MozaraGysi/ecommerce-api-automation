package Wallet.Validators;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

public class StatusCodeUnprocessableEntityValidator implements Validator {
	@Override
	public boolean validate(Response response) {
		Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.getStatusCode());

		return true;
	}
}
