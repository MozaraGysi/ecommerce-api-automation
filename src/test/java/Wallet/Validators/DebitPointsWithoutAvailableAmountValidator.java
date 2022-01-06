package Wallet.Validators;

import AutomationUtils.Validator;
import Wallet.DTOs.ErrorMessageResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DebitPointsWithoutAvailableAmountValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		ErrorMessageResponseDTO errorMessageResponseDTO = new ErrorMessageResponseDTO().fromJsonString(response.getBody().asString());

		Assertions.assertEquals("422", errorMessageResponseDTO.getCode());

		return true;
	}
}
