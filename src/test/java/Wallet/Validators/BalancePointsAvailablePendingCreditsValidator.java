package Wallet.Validators;

import Wallet.DTOs.BalancePointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class BalancePointsAvailablePendingCreditsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		BalancePointsResponseDTO balancePointsResponseDTO = new BalancePointsResponseDTO().fromJsonString(response.getBody().asString());

		Assertions.assertEquals(Utils.getCPF(), balancePointsResponseDTO.getDocument());
		Assertions.assertNotNull(balancePointsResponseDTO.getLastDateTime());
		Assertions.assertNotNull(balancePointsResponseDTO.getAmount());
		Assertions.assertEquals(Utils.getAvailableAmount(), balancePointsResponseDTO.getAmount().getAvailable());
		Assertions.assertEquals(Utils.getPendingAmount(), balancePointsResponseDTO.getAmount().getPendingCredit());
		Assertions.assertEquals(0, balancePointsResponseDTO.getAmount().getPendingDebit());

		return true;
	}
}