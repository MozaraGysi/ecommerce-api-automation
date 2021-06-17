package Wallet.Validators;

import Wallet.DTOs.EarnPointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class EarnPointsWithTransactionIdValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		EarnPointsResponseDTO earnPointsResponseDTO = EarnPointsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertNotNull(earnPointsResponseDTO.getTransactionId());

		return true;
	}
}



