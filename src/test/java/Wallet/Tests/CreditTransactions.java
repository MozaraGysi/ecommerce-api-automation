package Wallet.Tests;

import Wallet.Pages.AuthPage;
import Wallet.Pages.CreditPointsPage;
import Wallet.Pages.CreditTransactionsPage;
import Wallet.Pages.CustomerPage;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditTransactions {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void creditTransactionsWithStatusPENDENTE() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
	}

	@Test
	public void creditTransactionsWithStatusCONFIRMADO() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
	}
}
