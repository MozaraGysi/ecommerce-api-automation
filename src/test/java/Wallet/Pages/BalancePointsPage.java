package Wallet.Pages;

import Wallet.APIClient;
import Wallet.Utils.Utils;
import Wallet.Validators.BalancePointsWithoutAvailableAmountValidator;
import Wallet.Validators.StatusCodeOKValidator;
import Wallet.Validators.Validator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class BalancePointsPage {
	public static void getBalancePoints() {
		Response response = APIClient.GET_balancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getBalancePointsWithoutAvailableAmount() {
		Response response = APIClient.GET_balancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
		// TODO: Add after remove API mocks
		// new BalancePointsWithoutAvailableAmountValidator()
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
