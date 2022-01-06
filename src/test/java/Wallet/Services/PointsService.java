package Wallet.Services;

import AutomationUtils.Validator;
import Wallet.Utils.APIClient;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class PointsService {

	public static void getPoints() {
		Response response = APIClient.GET_points(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new PointsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getPointsPending() {
		Response response = APIClient.GET_points(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new PointsPendingValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getPointsWithoutTransactions() {
		Response response = APIClient.GET_points(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new PointsWithoutTransactionsValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getPointsWithoutAuthentication() {
		Response response = APIClient.GET_points(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
