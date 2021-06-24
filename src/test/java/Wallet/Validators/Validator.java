package Wallet.Validators;

import io.restassured.response.Response;

public interface Validator {
	boolean validate(Response response);
}
