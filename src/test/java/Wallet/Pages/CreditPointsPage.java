package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.Fixtures.CreditPointsRequestDTOFixture;
import Wallet.Validators.CreditPointsWithTransactionIdValidator;
import Wallet.Validators.StatusCodeCreatedValidator;
import Wallet.Validators.Validator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CreditPointsPage {

	public static void creditPoints() {
		CreditPointsRequestDTO creditPointsRequestDTO = CreditPointsRequestDTOFixture.build();

		Response response = APIClient.POST_creditPoints(creditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
