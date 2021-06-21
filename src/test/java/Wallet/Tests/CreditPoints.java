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
	public void creditPointsWithTypeVALOR_MONETARIO() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPointsWithTypeVALOR_MONETARIO();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}

	@Test
	public void creditPointsWithTypeQUANTIDADE_DE_PONTOS() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPointsWithTypeQUANTIDADE_DE_PONTOS();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}

	@Test
	public void creditPointsWithoutOrder() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPointsWithoutOrder();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}

	@Test
	public void creditPointsWithoutAuthentication() {
		CreditPointsPage.creditPointsWithoutAuthentication();
	}

	@Test
	public void doubleCreditPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		BalancePointsPage.getBalancePointsWithoutTransactions();
		PointsPage.getPointsWithoutTransactions();
		CreditPointsPage.creditPoints();
		BalancePointsPage.getBalancePointsWithoutTransactions();
		PointsPage.getPointsWithoutTransactions();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsPage.getBalancePointsWithoutTransactions();
		PointsPage.getPointsWithoutTransactions();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsPage.getBalancePoints();
		PointsPage.getPoints();
	}

	@Test
	public void deleteCreditPoints() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CreditPointsPage.creditPoints();
		CreditTransactionsPage.getCreditTransactionsWithStatusCONFIRMADO();
		CreditPointsPage.deleteCreditPoints();
	}
}
