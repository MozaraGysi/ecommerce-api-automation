package Wallet.Tests;

import Wallet.Pages.AuthPage;
import Wallet.Pages.CustomerPage;
import Wallet.Pages.PointsPage;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Points {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void getPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		PointsPage.getPoints();
	}

	@Test
	public void getPointsWithoutTransactions() {
		AuthPage.getToken();
		CustomerPage.newUser();
		PointsPage.getPointsWithoutTransactions();
	}
}
