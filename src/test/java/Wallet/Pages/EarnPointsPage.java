package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.EarnPointsRequestDTO;
import Wallet.Fixtures.EarnPointsRequestDTOFixture;
import Wallet.Validators.Validator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class EarnPointsPage {

	public static void earnPoints() {
		EarnPointsRequestDTO earnPointsRequestDTO = EarnPointsRequestDTOFixture.build();

		Response response = APIClient.POST_earnPoints(earnPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList();
		// TODO: Add after remove API mocks
		// new StatusCodeCreatedValidator(), new EarnPointsWithTransactionIdValidator()
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
