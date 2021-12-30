package Wallet.Validators;

import Wallet.DTOs.BalancePointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class BalancePointsWithoutAvailableAmountValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		BalancePointsResponseDTO balancePointsResponseDTO = new BalancePointsResponseDTO().fromJsonString(response.getBody().asString());

		Assertions.assertEquals(0, balancePointsResponseDTO.getAmount().getAvailable());

		return true;
	}
}
