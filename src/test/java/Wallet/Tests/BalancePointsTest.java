package Wallet.Tests;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class BalancePointsTest {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void getBalancePointsWithoutTransactions() {
		AuthService.getToken();
		CustomerService.postNewUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
	}

	@Test
	public void getBalancePointsWithoutTransactionsAndCreditTransactionWithStatusPENDENTE() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePointsWithoutTransactions();
	}

	@Test
	public void getBalancePointsWithCreditTransaction() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
	}

	@Test
	public void getBalancePointsWithTransactions() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.postDebitPoints();
		BalancePointsService.getBalancePoints();
	}

	@Test
	public void getBalancePointsWithoutAuthentication() {
		BalancePointsService.getBalancePointsWithoutAuthentication();
	}
}
