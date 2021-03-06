package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.DebitPointsResponseDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class DebitPointsWithTransactionIdValidator implements Validator {

	@Override
	public void validate(Response response) {
		DebitPointsResponseDTO debitPointsResponseDTO = new DebitPointsResponseDTO().fromJsonString(response.getBody().asString());

		assertNotNull(debitPointsResponseDTO.getTransactionId());

	}
}
