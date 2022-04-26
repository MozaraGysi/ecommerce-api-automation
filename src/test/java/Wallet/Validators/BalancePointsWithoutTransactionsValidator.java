package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.BalancePointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class BalancePointsWithoutTransactionsValidator implements Validator {

	@Override
	public void validate(Response response) {
		BalancePointsResponseDTO balancePointsResponseDTO = new BalancePointsResponseDTO().fromJsonString(response.getBody().asString());

		assertEquals(Utils.getCPF(), balancePointsResponseDTO.getDocument());
		assertNull(balancePointsResponseDTO.getLastDateTime());
		assertNotNull(balancePointsResponseDTO.getAmount());
		assertEquals(0, balancePointsResponseDTO.getAmount().getAvailable());
		assertEquals(0, balancePointsResponseDTO.getAmount().getPendingCredit());
		assertEquals(0, balancePointsResponseDTO.getAmount().getPendingDebit());

	}
}