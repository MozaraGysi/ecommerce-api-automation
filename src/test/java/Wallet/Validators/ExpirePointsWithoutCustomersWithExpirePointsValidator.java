package Wallet.Validators;

import Wallet.DTOs.ExpirePointsResponseDTO;
import io.restassured.response.Response;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Assertions;

public class ExpirePointsWithoutCustomersWithExpirePointsValidator implements Validator {
	@Override
	public boolean validate(Response response) {
		ExpirePointsResponseDTO expirePointsResponseDTO = ExpirePointsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertTrue(CollectionUtils.isEmpty(expirePointsResponseDTO.getCustomers()));

		return true;
	}
}