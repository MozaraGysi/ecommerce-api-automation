package Wallet.Tests;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class PointsTest {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void getPointsWithoutTransactions() {
		AuthService.getToken();
		CustomerService.newUser();
		PointsService.getPointsWithoutTransactions();
	}

	@Test
	public void getPointsWithoutTransactionsAndCreditTransactionStatusPENDENTE() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		PointsService.getPointsWithoutTransactions();
	}

	@Test
	public void getPointsWithTransactions() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.debitPoints();
		PointsService.getPoints();
	}

	@Test
	public void getPointsWithoutAuthentication() {
		PointsService.getPointsWithoutAuthentication();
	}
}
