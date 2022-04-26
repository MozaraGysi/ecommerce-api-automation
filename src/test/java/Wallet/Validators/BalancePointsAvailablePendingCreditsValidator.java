package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.BalancePointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class BalancePointsAvailablePendingCreditsValidator implements Validator {

	@Override
	public void validate(Response response) {
		BalancePointsResponseDTO balancePointsResponseDTO = new BalancePointsResponseDTO().fromJsonString(response.getBody().asString());

		assertEquals(Utils.getCPF(), balancePointsResponseDTO.getDocument());
		assertNotNull(balancePointsResponseDTO.getLastDateTime());
		assertNotNull(balancePointsResponseDTO.getAmount());
		assertEquals(Utils.getAvailableAmount(), balancePointsResponseDTO.getAmount().getAvailable());
		assertEquals(Utils.getPendingAmount(), balancePointsResponseDTO.getAmount().getPendingCredit());
		assertEquals(0, balancePointsResponseDTO.getAmount().getPendingDebit());

	}
}