package Wallet.Services;

import Wallet.Utils.APIClient;
import Wallet.Validators.ExpirePointsWithCustomersWithExpirePointsValidator;
import Wallet.Validators.ExpirePointsWithoutCustomersWithExpirePointsValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.Month;

public class ExpirePointsService {
	public static void getExpirePointsWithoutCustomersWithExpirePoints() {
		String currentDate = LocalDate.of(9000, Month.APRIL,1).toString();

		Response response = APIClient.getExpirePoints(currentDate);

		new ExpirePointsWithoutCustomersWithExpirePointsValidator().validate(response);
	}

	public static void getExpirePointsWithCustomersWithExpirePoints() {
		String currentDate = LocalDate.now().plusDays(90L).toString();

		Response response = APIClient.getExpirePoints(currentDate);

		new ExpirePointsWithCustomersWithExpirePointsValidator().validate(response);
	}
}
