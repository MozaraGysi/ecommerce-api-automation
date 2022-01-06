package Wallet.Validators;

import AutomationUtils.Validator;
import Wallet.DTOs.DebitPointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DebitPointsWithTransactionIdValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		DebitPointsResponseDTO debitPointsResponseDTO = new DebitPointsResponseDTO().fromJsonString(response.getBody().asString());

		Assertions.assertNotNull(debitPointsResponseDTO.getTransactionId());

		return true;
	}
}
