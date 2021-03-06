package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.ExpirePointsResponseDTO;
import io.restassured.response.Response;
import org.apache.commons.collections.CollectionUtils;

import static org.junit.jupiter.api.Assertions.*;

public class ExpirePointsWithoutCustomersWithExpirePointsValidator implements Validator {
	@Override
	public void validate(Response response) {
		ExpirePointsResponseDTO expirePointsResponseDTO = new ExpirePointsResponseDTO().fromJsonString(response.getBody().asString());

		assertTrue(CollectionUtils.isEmpty(expirePointsResponseDTO.getCustomers()));

	}
}
