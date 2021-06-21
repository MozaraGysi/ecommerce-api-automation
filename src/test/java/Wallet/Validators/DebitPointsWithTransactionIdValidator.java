package Wallet.Validators;

import Wallet.DTOs.DebitPointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DebitPointsWithTransactionIdValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		DebitPointsResponseDTO debitPointsResponseDTO = DebitPointsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertNotNull(debitPointsResponseDTO.getTransactionId());

		return true;
	}
}
