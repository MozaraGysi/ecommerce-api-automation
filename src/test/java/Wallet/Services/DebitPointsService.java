package Wallet.Services;

import Common.Validators.*;
import Wallet.Utils.APIClient;
import Wallet.DTOs.Request.DebitPointsRequestDTO;
import Wallet.DTOs.Response.DebitPointsResponseDTO;
import Wallet.DTOs.Request.DeleteDebitPointsRequestDTO;
import Wallet.Fixtures.DebitPointsRequestDTOFixture;
import Wallet.Fixtures.DeleteDebitPointsRequestDTOFixture;
import Wallet.Handlers.DebitPointsHandler;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class DebitPointsService {

	public static void postDebitPoints() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().build();

		Response response = APIClient.postDebitPoints(debitPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void postDebitPointsWithTypeQUANTIDADE_DE_PONTOS() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().type_QUANTIDADE_DE_PONTOS().build();

		Response response = APIClient.postDebitPoints(debitPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void postDebitPointsWithTypeVALOR_MONETARIO() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().type_VALOR_MONETARIO().build();

		Response response = APIClient.postDebitPoints(debitPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void postDebitPointsWithoutOrder() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().withoutOrder().build();

		Response response = APIClient.postDebitPoints(debitPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void postDebitPointsToReturnLastCredit() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().returnLastCreditPoints().build();

		Response response = APIClient.postDebitPoints(debitPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new DebitPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleDebitPoints(debitPointsRequestDTO, response);
	}

	public static void postDebitPointsWithoutAuthentication() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().build();

		Response response = APIClient.postDebitPoints(debitPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void postDebitPointsWithoutAvailableAmount() {
		DebitPointsRequestDTO debitPointsRequestDTO = new DebitPointsRequestDTOFixture().withoutAvailableAmount().build();

		Response response = APIClient.postDebitPoints(debitPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator(), new DebitPointsWithoutAvailableAmountValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void deletedDebitPoints() {
		DeleteDebitPointsRequestDTO deleteDebitPointsRequestDTO = new DeleteDebitPointsRequestDTOFixture().build();

		Response response = APIClient.deleteDebitPoints(deleteDebitPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new DeletedDebitPointsPointsValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	private static void handleDebitPoints(DebitPointsRequestDTO debitPointsRequestDTO, Response response) {
		DebitPointsResponseDTO debitPointsResponseDTO = new DebitPointsResponseDTO().fromJsonString(response.getBody().asString());
		Utils.addDebitPoints(new DebitPointsHandler(debitPointsResponseDTO.getTransactionId(), debitPointsRequestDTO));

	}
}
