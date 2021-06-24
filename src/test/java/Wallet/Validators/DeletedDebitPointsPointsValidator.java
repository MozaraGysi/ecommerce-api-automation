package Wallet.Validators;

import Wallet.DTOs.DeleteDebitPointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DeletedDebitPointsPointsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		DeleteDebitPointsResponseDTO deleteDebitPointsRequestDTO = DeleteDebitPointsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertFalse(deleteDebitPointsRequestDTO.getTransactionId().isEmpty());

		return true;
	}
}

