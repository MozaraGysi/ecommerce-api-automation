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
	public void getBalancePointsWithoutTransactionsAndCreditTransactionWithStatusPENDENTE() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsPage.getBalancePointsWithoutTransactions();
	}

	@Test
	public void getBalancePointsWithCreditTransaction() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
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

	@Test
	public void getBalancePointsWithoutAuthentication() {
		BalancePointsPage.getBalancePointsWithoutAuthentication();
	}
}
