package Wallet.Scenarios;

import Wallet.Services.*;
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
		PointsPage.getPoints();
	}

	@Test
	public void debitPointsWithTypeVALOR_MONETARIO() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPointsWithTypeVALOR_MONETARIO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}

	@Test
	public void debitPointsWithoutOrder() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPointsWithoutOrder();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}

	@Test
	public void debitPointsWithoutAuthentication() {
		DebitPointsPage.debitPointsWithoutAuthentication();
	}

	@Test
	public void debitPointsWithoutAvailableAmount() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsPage.debitPointsWithoutAvailableAmount();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
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
