package Wallet.Validators;

import AutomationUtils.Validator;
import Wallet.DTOs.PointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class PointsWithoutTransactionsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		PointsResponseDTO pointsResponseDTO = new PointsResponseDTO().fromJsonString(response.getBody().asString());

		Assertions.assertEquals(Utils.getCPF(), pointsResponseDTO.getDocument());

		Assertions.assertNotNull(pointsResponseDTO.getBalance());
		Assertions.assertEquals(0, pointsResponseDTO.getBalance().getAvailable());
		Assertions.assertEquals(0, pointsResponseDTO.getBalance().getPendingCredits());
		Assertions.assertEquals(0, pointsResponseDTO.getBalance().getPendingDebits());
		Assertions.assertNull(pointsResponseDTO.getBalance().getLastDateTime());

		Assertions.assertTrue(pointsResponseDTO.getStatements().isEmpty());

		return true;
	}
}



