package Wallet.Tests;

import Wallet.Pages.AuthPage;
import Wallet.Pages.CustomerPage;
import Wallet.Pages.CreditPointsPage;
import Wallet.Pages.PointsPage;
import Wallet.Utils.Utils;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class CreditPoints {

	@Before
	public void init() {
		Utils.init();
	}

	@Test
	public void creditPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		PointsPage.getPoints();
		CreditPointsPage.creditPoints();
	}
}
