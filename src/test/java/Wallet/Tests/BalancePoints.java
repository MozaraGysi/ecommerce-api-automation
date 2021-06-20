package Wallet.Tests;

import Wallet.Pages.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BalancePoints {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void getBalancePointsWithoutTransactions() {
		AuthPage.getToken();
		CustomerPage.newUser();
		BalancePointsPage.getBalancePointsWithoutTransactions();
	}

	@Test
	public void getBalancePointsWithTransactions() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPoints();
		BalancePointsPage.getBalancePoints();
	}
}
