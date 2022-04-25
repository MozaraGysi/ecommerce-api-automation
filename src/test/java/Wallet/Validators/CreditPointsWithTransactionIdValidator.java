package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.CreditPointsResponseDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class CreditPointsWithTransactionIdValidator implements Validator {

	@Override
	public void validate(Response response) {
		CreditPointsResponseDTO creditPointsResponseDTO = new CreditPointsResponseDTO().fromJsonString(response.getBody().asString());

		assertNotNull(creditPointsResponseDTO.getTransactionId());

	}
}



