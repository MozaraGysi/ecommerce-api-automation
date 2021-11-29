package Wallet.Scenarios;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Returns {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void creditAndReturn() {
		AuthPage.getToken();
		CustomerPage.newUser();
		BalancePointsPage.getBalancePointsWithoutTransactions();
		PointsPage.getPointsWithoutTransactions();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsPage.getBalancePointsWithoutTransactions();
		PointsPage.getPointsWithoutTransactions();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
		DebitPointsPage.debitPointsToReturnLastCredit();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}

	@Test
	public void debitAndReturnOrCancel() {
		AuthPage.getToken();
		CustomerPage.newUser();
		BalancePointsPage.getBalancePointsWithoutTransactions();
		PointsPage.getPointsWithoutTransactions();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsPage.getBalancePointsWithoutTransactions();
		PointsPage.getPointsWithoutTransactions();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
		DebitPointsPage.debitPoints();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
		CreditPointsPage.creditPointsToReturnLastDebit();
		BalancePointsPage.getBalancePoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsPage.getBalancePoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}
}
