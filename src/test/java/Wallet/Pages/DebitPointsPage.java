package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.DebitPointsRequestDTO;
import Wallet.DTOs.DeleteDebitPointsRequestDTO;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class DebitPointsPage {

	public static void debitPoints() {
		DebitPointsRequestDTO debitPointsRequestDTO = DebitPointsRequestDTO.build();

		Response response = APIClient.POST_debitPoints(debitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void deletedDebitPoints() {
		DeleteDebitPointsRequestDTO deleteDebitPointsRequestDTO = DeleteDebitPointsRequestDTO.build();
		Response response = APIClient.DELETE_debitPoints(deleteDebitPointsRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new DeletedCreditPointsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
