package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.PointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class PointsWithoutTransactionsValidator implements Validator {

	@Override
	public void validate(Response response) {
		PointsResponseDTO pointsResponseDTO = new PointsResponseDTO().fromJsonString(response.getBody().asString());

		assertEquals(Utils.getCPF(), pointsResponseDTO.getDocument());

		assertNotNull(pointsResponseDTO.getBalance());
		assertEquals(0, pointsResponseDTO.getBalance().getAvailable());
		assertEquals(0, pointsResponseDTO.getBalance().getPendingCredits());
		assertEquals(0, pointsResponseDTO.getBalance().getPendingDebits());
		assertNull(pointsResponseDTO.getBalance().getLastDateTime());

		assertTrue(pointsResponseDTO.getStatements().isEmpty());

	}
}



