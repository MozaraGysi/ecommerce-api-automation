package Wallet.Tests;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class CreditTransactionsTest {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void creditTransactionsWithStatusPENDENTE() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
	}

	@Test
	public void creditTransactionsWithStatusCONFIRMADO() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void creditTransactionsWithoutAuthentication() {
		CreditTransactionsService.creditTransactionsWithoutAuthentication();
	}
}