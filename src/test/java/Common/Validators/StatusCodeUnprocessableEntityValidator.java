package Common.Validators;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

public class StatusCodeUnprocessableEntityValidator implements Validator {
	@Override
	public void validate(Response response) {
		assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.getStatusCode());

	}
}
