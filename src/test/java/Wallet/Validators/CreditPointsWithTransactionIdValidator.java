package Wallet.Validators;

import Wallet.DTOs.CreditPointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CreditPointsWithTransactionIdValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		CreditPointsResponseDTO creditPointsResponseDTO = CreditPointsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertNotNull(creditPointsResponseDTO.getTransactionId());

		return true;
	}
}


