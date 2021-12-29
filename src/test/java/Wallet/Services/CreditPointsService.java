package Wallet.Services;

import Wallet.Utils.APIClient;
import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.DTOs.CreditPointsResponseDTO;
import Wallet.DTOs.DeleteCreditPointsRequestDTO;
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

	public static void creditPoints() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().build();

		Response response = APIClient.POST_creditPoints(creditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void creditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().type_QUANTIDADE_DE_PONTOS().build();

		Response response = APIClient.POST_creditPoints(creditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void creditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(int index) {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture()
				.withOrder(Utils.getCreditPoints().get(index).getRequestDTO().getOrder())
				.type_VALOR_MONETARIO()
				.build();

		Response response = APIClient.POST_creditPoints(creditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void creditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().type_VALOR_MONETARIO().status_PENDENTE().build();

		Response response = APIClient.POST_creditPoints(creditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void creditPointsWithoutOrder() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().withoutOrder().build();

		Response response = APIClient.POST_creditPoints(creditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void creditPointsToReturnLastDebit() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().returnLastDebitPoints().build();

		Response response = APIClient.POST_creditPoints(creditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleCreditPoints(creditPointsRequestDTO, response);
	}

	public static void creditPointsWithoutAuthentication() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTOFixture().build();

		Response response = APIClient.POST_creditPoints(creditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void deleteCreditPoints() {
		DeleteCreditPointsRequestDTO deleteCreditPointsRequestDTO = new DeleteCreditPointsRequestDTOFixture().build();

		Response response = APIClient.DELETE_creditPoints(deleteCreditPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new DeleteCreditPointsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	private static void handleCreditPoints(CreditPointsRequestDTO creditPointsRequestDTO, Response response) {
		CreditPointsResponseDTO creditPointsResponseDTO = CreditPointsResponseDTO.fromJsonString(response.getBody().asString());
		Utils.addCreditPoints(new CreditPointsHandler(creditPointsResponseDTO.getTransactionId(), creditPointsRequestDTO));
	}
}
