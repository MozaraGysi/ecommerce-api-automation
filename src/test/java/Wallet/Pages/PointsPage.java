package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.DeletedCreditPointsDTO;
import Wallet.Utils.Utils;
import Wallet.Validators.PointsWithoutTransactionsValidator;
import Wallet.Validators.DeletedCreditPointsValidator;
import Wallet.Validators.StatusCodeOKValidator;
import Wallet.Validators.Validator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class PointsPage {

	public static void getPoints() {
		Response response = APIClient.GET_points(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getPointsWithoutTransactions() {
		Response response = APIClient.GET_points(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new PointsWithoutTransactionsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
