package Wallet.Tests;

import Wallet.Pages.AuthPage;
import Wallet.Pages.BalancePointsPage;
import Wallet.Pages.CustomerPage;
import Wallet.Utils.Utils;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class BalancePoints {

	@Before
	public void init() {
		Utils.init();
	}

	@Test
	public void getBalancePoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		BalancePointsPage.getBalancePoints();
	}

	@Test
	public void getBalancePointsWithoutAvailableAmount() {
		AuthPage.getToken();
		CustomerPage.newUser();
		BalancePointsPage.getBalancePointsWithoutAvailableAmount();
	}
}
