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

public class PointsService {

	public static void getPoints() {
		Response response = APIClient.getPoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new PointsValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void getPointsPending() {
		Response response = APIClient.getPoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new PointsPendingValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void getPointsWithoutTransactions() {
		Response response = APIClient.getPoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new PointsWithoutTransactionsValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void getPointsWithoutAuthentication() {
		Response response = APIClient.getPoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}
}
