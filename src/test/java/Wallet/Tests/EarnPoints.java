package Wallet.Tests;

import Wallet.Pages.AuthPage;
import Wallet.Pages.CustomerPage;
import Wallet.Pages.EarnPointsPage;
import Wallet.Pages.PointsPage;
import Wallet.Utils.Utils;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class EarnPoints {

	@Before
	public void init() {
		Utils.init();
	}

	@Test
	public void getEarnPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		PointsPage.getPoints();
		EarnPointsPage.earnPoints();
	}
}
