package Wallet.Scenarios;

import Wallet.Services.AuthPage;
import Wallet.Services.CustomerPage;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Customer {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void newUser() {
		AuthPage.getToken();
		CustomerPage.newUser();
	}

	@Test
	public void newUserWithoutAuthentication() {
		CustomerPage.newUserWithoutAuthentication();
	}

	@Test
	public void newUserWithoutCPF() {
		AuthPage.getToken();
		CustomerPage.newUserWithoutCPF();
	}

	@Test
	public void newUserWithInvalidCPF() {
		AuthPage.getToken();
		CustomerPage.newUserWithInvalidCPF();
	}

	@Test
	public void newUserWithoutFirstName() {
		AuthPage.getToken();
		CustomerPage.newUserWithoutFirstName();
	}

	@Test
	public void newUserWithoutLastName() {
		AuthPage.getToken();
		CustomerPage.newUserWithoutLastName();
	}

	@Test
	public void newUserWithInvalidMobile() {
		AuthPage.getToken();
		CustomerPage.newUserWithInvalidMobile();
	}
}
