package Wallet.Scenarios;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class Returns {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void creditAndReturn() {
		AuthService.getToken();
		CustomerService.postNewUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		DebitPointsService.postDebitPointsToReturnLastCredit();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void debitAndReturnOrCancel() {
		AuthService.getToken();
		CustomerService.postNewUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		DebitPointsService.postDebitPoints();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		CreditPointsService.postCreditPointsToReturnLastDebit();
		BalancePointsService.getBalancePoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}
}
