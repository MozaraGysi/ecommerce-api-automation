package Common.Validators;

import Common.Validators.Validator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

public class StatusCodeOKValidator implements Validator {
	@Override
	public boolean validate(Response response) {
		Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode());

		return true;
	}
}