package Wallet.Scenarios;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class Points {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void getPointsWithoutTransactions() {
		AuthService.getToken();
		CustomerService.postNewUser();
		PointsService.getPointsWithoutTransactions();
	}

	@Test
	public void getPointsWithoutTransactionsAndCreditTransactionStatusPENDENTE() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		PointsService.getPointsWithoutTransactions();
	}

	@Test
	public void getPointsWithTransactions() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.postDebitPoints();
		PointsService.getPoints();
	}

	@Test
	public void getPointsWithoutAuthentication() {
		PointsService.getPointsWithoutAuthentication();
	}
}
