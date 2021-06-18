package Wallet.Tests;

import Wallet.Pages.*;
import Wallet.Utils.Utils;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class DebitPoints {

	@Before
	public void init() {
		Utils.init();
	}

	@Test
	public void debitPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		DebitPointsPage.debitPoints();
	}

	@Test
	public void deleteDebitPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		PointsPage.getPoints();
		DebitPointsPage.debitPoints();
		DebitPointsPage.deletedDebitPoints();
	}
}
