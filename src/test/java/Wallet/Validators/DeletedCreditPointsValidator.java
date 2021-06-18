package Wallet.Validators;

import Wallet.DTOs.DeletedCreditPointsDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DeletedCreditPointsValidator  implements Validator{
	@Override
	public boolean validate(Response response) {
		DeletedCreditPointsDTO deletedEarnPointsResponseDTO = DeletedCreditPointsDTO.fromJsonString(response.getBody().asString());
		Assertions.assertFalse(deletedEarnPointsResponseDTO.getTransactionId().isEmpty());

		return true;
	}
}
