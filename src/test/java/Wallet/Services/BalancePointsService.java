package Wallet.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.StatusCodeUnauthorizedValidator;
import Common.Validators.Validator;
import Wallet.Utils.APIClient;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class BalancePointsService {
	public static void getBalancePoints() {
		Response response = APIClient.getBalancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new BalancePointsValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void getBalancePointsWithoutTransactions() {
		Response response = APIClient.getBalancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new BalancePointsWithoutTransactionsValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void getBalancePointsWithoutAuthentication() {
		Response response = APIClient.getBalancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void getBalancePointsWithPendingCredits() {
		Response response = APIClient.getBalancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new BalancePointsAvailablePendingCreditsValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}
}
