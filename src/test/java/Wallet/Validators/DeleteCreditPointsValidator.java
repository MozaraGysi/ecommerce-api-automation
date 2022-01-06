package Wallet.Validators;

import AutomationUtils.Validator;
import Wallet.DTOs.DeleteCreditPointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DeleteCreditPointsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		DeleteCreditPointsResponseDTO deleteCreditPointsResponseDTO = new DeleteCreditPointsResponseDTO().fromJsonString(response.getBody().asString());
		Assertions.assertNotNull(deleteCreditPointsResponseDTO.getTransactionId());

		return true;
	}
}
