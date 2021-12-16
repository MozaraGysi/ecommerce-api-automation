package Wallet.Scenarios;

import Wallet.Services.*;
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
		AuthService.getToken();
		CustomerService.newUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
	}

	@Test
	public void getBalancePointsWithoutTransactionsAndCreditTransactionWithStatusPENDENTE() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePointsWithoutTransactions();
	}

	@Test
	public void getBalancePointsWithCreditTransaction() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
	}

	@Test
	public void getBalancePointsWithTransactions() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.debitPoints();
		BalancePointsService.getBalancePoints();
	}

	@Test
	public void getBalancePointsWithoutAuthentication() {
		BalancePointsService.getBalancePointsWithoutAuthentication();
	}
}
