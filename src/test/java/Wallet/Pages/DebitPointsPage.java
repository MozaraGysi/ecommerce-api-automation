package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.DebitPointsDTO;
import Wallet.DTOs.DeletedPointsDTO;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class DebitPointsPage {

	public static void debitPoints() {
		DebitPointsDTO debitPointsDTO = DebitPointsDTO.build();

		Response response = APIClient.POST_debitPoints(debitPointsDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditPointsWithTransactionIdValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void deletedDebitPoints() {
		DeletedPointsDTO deletedPointsDTO = DeletedPointsDTO.build();
		Response response = APIClient.DELETE_debitPoints(deletedPointsDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new DeletedCreditPointsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
