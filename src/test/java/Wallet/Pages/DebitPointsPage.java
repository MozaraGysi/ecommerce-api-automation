package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.DebitPointsRequestDTO;
import Wallet.DTOs.DebitPointsResponseDTO;
import Wallet.DTOs.DeleteDebitPointsRequestDTO;
import Wallet.Fixtures.DebitPointsRequestDTOFixture;
import Wallet.Fixtures.DeleteDebitPointsRequestDTOFixture;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class DebitPointsPage {

	public static void debitPoints() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().build();

		Response response = APIClient.POST_debitPoints(debitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		DebitPointsResponseDTO debitPointsResponseDTO = DebitPointsResponseDTO.fromJsonString(response.getBody().asString());
		Utils.setTRANSACTION_ID(debitPointsResponseDTO.getTransactionId());
	}

	public static void deletedDebitPoints() {
		DeleteDebitPointsRequestDTO deleteDebitPointsRequestDTO = new DeleteDebitPointsRequestDTOFixture().build();

		Response response = APIClient.DELETE_debitPoints(deleteDebitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new DeletedDebitPointsPointsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
