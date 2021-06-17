package Wallet.Tests;

import Wallet.Pages.AuthPage;
import Wallet.Pages.CustomerPage;
import Wallet.Pages.CustomerPointsPage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Customer {

	@Test
	@Order(1)
	public void newUserWithGetBalance() {
		AuthPage.getToken();
		CustomerPage.newUser();
		CustomerPointsPage.getBalancePointsWithoutAmount();
		CustomerPointsPage.getPointsWithoutTransactions();
	}
}
