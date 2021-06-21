package Wallet.Validators;

import Wallet.DTOs.ErrorMessageResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DebitPointsWithoutAvailableAmountValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		ErrorMessageResponseDTO errorMessageResponseDTO = ErrorMessageResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertEquals("422", errorMessageResponseDTO.getCode());
		Assertions.assertNotEquals("Não há saldo suficiente.", errorMessageResponseDTO.getMessage());

		return true;
	}
}
