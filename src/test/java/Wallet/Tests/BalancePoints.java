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
	public void getBalancePointsWithoutAvailableAmount() {
		AuthPage.getToken();
		CustomerPage.newUser();
		BalancePointsPage.getBalancePoints();
	}

	@Test
	public void getBalancePointsWithAvailableAmount() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
	}
}
