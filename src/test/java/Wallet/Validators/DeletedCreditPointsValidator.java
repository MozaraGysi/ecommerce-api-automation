package Wallet.Validators;

import Wallet.DTOs.DeletedPointsDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DeletedCreditPointsValidator  implements Validator{
	@Override
	public boolean validate(Response response) {
		DeletedPointsDTO deletedEarnPointsResponseDTO = DeletedPointsDTO.fromJsonString(response.getBody().asString());
		Assertions.assertFalse(deletedEarnPointsResponseDTO.getTransactionId().isEmpty());

		return true;
	}
}
