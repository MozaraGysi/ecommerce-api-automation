package Wallet.Validators;

import Wallet.DTOs.BalancePointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class BalancePointsAvailableAmountValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		BalancePointsResponseDTO balancePointsResponseDTO = BalancePointsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertEquals(Utils.getAvailableAmount(), balancePointsResponseDTO.getAmount().getAvailable());

		return true;
	}
}