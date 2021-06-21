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
	public void getPointsWithoutTransactionsAndCreditTransactionStatusPENDENTE() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		PointsPage.getPointsWithoutTransactions();
	}

	@Test
	public void getPointsWithTransactions() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPoints();
		PointsPage.getPoints();
	}

	@Test
	public void getPointsWithoutAuthentication() {
		PointsPage.getPointsWithoutAuthentication();
	}
}
