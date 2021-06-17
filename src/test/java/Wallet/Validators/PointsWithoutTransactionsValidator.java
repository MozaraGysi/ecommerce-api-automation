package Wallet.Validators;

import Wallet.DTOs.PointsResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class PointsWithoutTransactionsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		PointsResponseDTO pointsResponseDTO = PointsResponseDTO.fromJsonString(response.getBody().asString());
		Assertions.assertTrue(pointsResponseDTO.getStatements().isEmpty());

		return true;
	}
}



