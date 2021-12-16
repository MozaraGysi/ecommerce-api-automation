package Wallet.Scenarios;

import Wallet.Services.*;
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
