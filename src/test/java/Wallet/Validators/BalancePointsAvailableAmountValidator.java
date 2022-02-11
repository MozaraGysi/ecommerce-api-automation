package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.BalancePointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class BalancePointsAvailableAmountValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		BalancePointsResponseDTO balancePointsResponseDTO = new BalancePointsResponseDTO().fromJsonString(response.getBody().asString());

		Assertions.assertEquals(Utils.getAvailableAmount(), balancePointsResponseDTO.getAmount().getAvailable());

		return true;
	}
}