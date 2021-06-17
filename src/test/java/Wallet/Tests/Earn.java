package Wallet.Tests;

import Wallet.Pages.AuthPage;
import Wallet.Pages.CustomerPage;
import Wallet.Pages.CustomerPointsPage;
import Wallet.Validators.BalanceWithoutAvailableAmountValidator;
import Wallet.Validators.StatusCodeCreatedValidator;
import Wallet.Validators.StatusCodeOKValidator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Earn {

	@Test
	@Order(1)
	public void newUserWithGetBalance() {
		AuthPage.getToken();
		CustomerPage.newUser(new StatusCodeCreatedValidator());
		CustomerPointsPage.getBalance(new StatusCodeOKValidator(), new BalanceWithoutAvailableAmountValidator());
	}
}
