package Common.Validators;

import io.restassured.response.Response;

public interface Validator {
	void validate(Response response);
}
