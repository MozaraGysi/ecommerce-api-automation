package Wallet.Tests;

import Wallet.Pages.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DebitPoints {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void debitPointsWithTypeQUANTIDADE_DE_PONTOS() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPointsWithTypeQUANTIDADE_DE_PONTOS();
		BalancePointsPage.getBalancePoints();
	}

	@Test
	public void debitPointsWithTypeVALOR_MONETARIO() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPointsWithTypeVALOR_MONETARIO();
		BalancePointsPage.getBalancePoints();
	}

	@Test
	public void debitPointsWithoutOrder() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPointsWithoutOrder();
		BalancePointsPage.getBalancePoints();
	}

	@Test
	public void deleteDebitPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPoints();
		DebitPointsPage.deletedDebitPoints();
	}
}
