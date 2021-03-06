package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.DeleteDebitPointsResponseDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class DeletedDebitPointsPointsValidator implements Validator {

	@Override
	public void validate(Response response) {
		DeleteDebitPointsResponseDTO deleteDebitPointsRequestDTO = new DeleteDebitPointsResponseDTO().fromJsonString(response.getBody().asString());

		assertFalse(deleteDebitPointsRequestDTO.getTransactionId().isEmpty());

	}
}

