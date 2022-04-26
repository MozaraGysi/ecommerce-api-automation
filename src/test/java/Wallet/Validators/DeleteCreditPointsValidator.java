package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.DeleteCreditPointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DeleteCreditPointsValidator implements Validator {

	@Override
	public void validate(Response response) {
		DeleteCreditPointsResponseDTO deleteCreditPointsResponseDTO = new DeleteCreditPointsResponseDTO().fromJsonString(response.getBody().asString());
		Assertions.assertNotNull(deleteCreditPointsResponseDTO.getTransactionId());

	}
}
