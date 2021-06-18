package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.DTOs.CreditPointsResponseDTO;
import Wallet.DTOs.DeleteCreditPointsRequestDTO;
import Wallet.Fixtures.CreditPointsRequestDTOFixture;
import Wallet.Fixtures.DeleteCreditPointsRequestDTOFixture;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
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

		CreditPointsResponseDTO creditPointsResponseDTO = CreditPointsResponseDTO.fromJsonString(response.getBody().asString());
		Utils.setTRANSACTION_ID(creditPointsResponseDTO.getTransactionId());
	}

	public static void deleteCreditPoints() {
		DeleteCreditPointsRequestDTO deleteCreditPointsRequestDTO = DeleteCreditPointsRequestDTOFixture.build();

		Response response = APIClient.DELETE_creditPoints(deleteCreditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new DeleteCreditPointsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
