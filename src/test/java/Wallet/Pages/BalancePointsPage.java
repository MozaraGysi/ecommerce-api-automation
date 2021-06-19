package Wallet.Pages;

import Wallet.APIClient;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class BalancePointsPage {
	public static void getBalancePoints() {
		Response response = APIClient.GET_balancePoints(Utils.getCPF());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new BalancePointsValidator(), new BalancePointsAvailableAmountValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
