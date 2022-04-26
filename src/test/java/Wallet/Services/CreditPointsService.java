package Wallet.Services;

import Common.Validators.StatusCodeCreatedValidator;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.StatusCodeUnauthorizedValidator;
import Common.Validators.Validator;
import Wallet.Utils.APIClient;
import Wallet.DTOs.Request.CreditPointsRequestDTO;
import Wallet.DTOs.Response.CreditPointsResponseDTO;
import Wallet.DTOs.Request.DeleteCreditPointsRequestDTO;
import Wallet.Fixtures.CreditPointsRequestDTOFixture;
import Wallet.Fixtures.DeleteCreditPointsRequestDTOFixture;
import Wallet.Handlers.CreditPointsHandler;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CreditPointsService {

	public static void postCreditPoints() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().build();

		Response response = APIClient.postCreditPoints(creditPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void postCreditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().type_QUANTIDADE_DE_PONTOS().build();

		Response response = APIClient.postCreditPoints(creditPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void postCreditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(int index) {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture()
				.withOrder(Utils.getCreditPoints().get(index).getRequestDTO().getOrder())
				.type_VALOR_MONETARIO()
				.build();

		Response response = APIClient.postCreditPoints(creditPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().type_VALOR_MONETARIO().status_PENDENTE().build();

		Response response = APIClient.postCreditPoints(creditPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void postCreditPointsWithoutOrder() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().withoutOrder().build();

		Response response = APIClient.postCreditPoints(creditPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void postCreditPointsToReturnLastDebit() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().returnLastDebitPoints().build();

		Response response = APIClient.postCreditPoints(creditPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void postCreditPointsWithoutAuthentication() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().build();

		Response response = APIClient.postCreditPoints(creditPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void deleteCreditPoints() {
		DeleteCreditPointsRequestDTO deleteCreditPointsRequestDTO = new DeleteCreditPointsRequestDTOFixture().build();

		Response response = APIClient.deleteCreditPoints(deleteCreditPointsRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new DeleteCreditPointsValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	private static void handleCreditPoints(CreditPointsRequestDTO creditPointsRequestDTO, Response response) {
		CreditPointsResponseDTO creditPointsResponseDTO = new CreditPointsResponseDTO().fromJsonString(response.getBody().asString());
		Utils.addCreditPoints(new CreditPointsHandler(creditPointsResponseDTO.getTransactionId(), creditPointsRequestDTO));
	}
}
