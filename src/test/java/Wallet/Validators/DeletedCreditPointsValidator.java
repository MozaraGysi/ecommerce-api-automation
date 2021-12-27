package Wallet.Validators;

import Wallet.DTOs.DeleteCreditPointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DeletedCreditPointsValidator implements Validator {
	@Override
	public boolean validate(Response response) {
		DeleteCreditPointsResponseDTO deleteCreditPointsResponseDTO = new DeleteCreditPointsResponseDTO().fromJsonString(response.getBody().asString());
		Assertions.assertFalse(deleteCreditPointsResponseDTO.getTransactionId().isEmpty());

		return true;
	}
}

