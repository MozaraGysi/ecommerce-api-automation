package Wallet.Services;

import AutomationUtils.Validator;
import Wallet.Utils.APIClient;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class BalancePointsService {
	public static void getBalancePoints() {
		Response response = APIClient.GET_balancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new BalancePointsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getBalancePointsWithoutTransactions() {
		Response response = APIClient.GET_balancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new BalancePointsWithoutTransactionsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getBalancePointsWithoutAuthentication() {
		Response response = APIClient.GET_balancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getBalancePointsWithPendingCredits() {
		Response response = APIClient.GET_balancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new BalancePointsAvailablePendingCreditsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
