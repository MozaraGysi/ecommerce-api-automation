package Wallet.Tests;

import Wallet.Pages.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditPoints {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void creditPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
	}

	@Test
	public void creditPointsWithTypeVALOR_MONETARIO() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPointsWithTypeVALOR_MONETARIO();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
	}

	@Test
	public void creditPointsWithTypeQUANTIDADE_DE_PONTOS() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPointsWithTypeQUANTIDADE_DE_PONTOS();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
	}

	@Test
	public void creditPointsWithoutOrder() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPointsWithoutOrder();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
	}

	@Test
	public void deleteCreditPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditPointsPage.deleteCreditPoints();
	}
}
