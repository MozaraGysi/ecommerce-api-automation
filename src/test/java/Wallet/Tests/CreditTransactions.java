package Wallet.Tests;

import Wallet.Pages.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditTransactions {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void creditTransactionsWithStatusPENDENTE() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsPage.getBalancePointsWithoutTransactions();
		PointsPage.getPointsWithoutTransactions();
	}

	@Test
	public void creditTransactionsWithStatusCONFIRMADO() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}

	@Test
	public void creditTransactionsWithoutAuthentication() {
		CreditTransactionsPage.creditTransactionsWithoutAuthentication();
	}
}
