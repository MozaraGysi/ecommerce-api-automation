package Wallet.Tests;

import Wallet.Pages.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Points {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void getPointsWithoutTransactions() {
		AuthPage.getToken();
		CustomerPage.newUser();
		PointsPage.getPointsWithoutTransactions();
	}

	@Test
	public void getPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPoints();
		PointsPage.getPoints();
	}
}
