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

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void debitPointsWithTypeQUANTIDADE_DE_PONTOS() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().type_QUANTIDADE_DE_PONTOS().build();

		Response response = APIClient.POST_debitPoints(debitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void debitPointsWithTypeVALOR_MONETARIO() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().type_VALOR_MONETARIO().build();

		Response response = APIClient.POST_debitPoints(debitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void debitPointsWithoutOrder() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().withoutOrder().build();

		Response response = APIClient.POST_debitPoints(debitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void debitPointsToReturnLastCredit() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().returnLastCreditPoints().build();

		Response response = APIClient.POST_debitPoints(debitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void deletedDebitPoints() {
		DeleteDebitPointsRequestDTO deleteDebitPointsRequestDTO = new DeleteDebitPointsRequestDTOFixture().build();

		Response response = APIClient.DELETE_debitPoints(deleteDebitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new DeletedDebitPointsPointsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	private static void handleDebitPoints(DebitPointsRequestDTO debitPointsRequestDTO, Response response) {
		DebitPointsResponseDTO debitPointsResponseDTO = DebitPointsResponseDTO.fromJsonString(response.getBody().asString());
		Utils.setDebitTransactionId(debitPointsResponseDTO.getTransactionId());
		Utils.setLastDebitPoints(debitPointsRequestDTO);
		Utils.debitPoints(debitPointsRequestDTO.getDebitAmount());
	}
}
