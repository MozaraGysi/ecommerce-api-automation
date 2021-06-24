package Wallet.Validators;

import Wallet.DTOs.BalancePointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class BalancePointsWithoutTransactionsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		BalancePointsResponseDTO balancePointsResponseDTO = BalancePointsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertEquals(Utils.getCPF(), balancePointsResponseDTO.getDocument());
		Assertions.assertNull(balancePointsResponseDTO.getLastDateTime());
		Assertions.assertNotNull(balancePointsResponseDTO.getAmount());
		Assertions.assertEquals(0, balancePointsResponseDTO.getAmount().getAvailable());
		Assertions.assertEquals(0, balancePointsResponseDTO.getAmount().getPendingCredit());
		Assertions.assertEquals(0, balancePointsResponseDTO.getAmount().getPendingDebit());

		return true;
	}
}