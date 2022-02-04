package Wallet.Scenarios;

import Wallet.Services.AuthService;
import Wallet.Services.CustomerService;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class Customer {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void newUser() {
		AuthService.getToken();
		CustomerService.postNewUser();
	}

	@Test
	public void newUserWithoutAuthentication() {
		CustomerService.postNewUserWithoutAuthentication();
	}

	@Test
	public void newUserWithoutCPF() {
		AuthService.getToken();
		CustomerService.postNewUserWithoutCPF();
	}

	@Test
	public void newUserWithInvalidCPF() {
		AuthService.getToken();
		CustomerService.postNewUserWithInvalidCPF();
	}

	@Test
	public void newUserWithoutFirstName() {
		AuthService.getToken();
		CustomerService.postNewUserWithoutFirstName();
	}

	@Test
	public void newUserWithoutLastName() {
		AuthService.getToken();
		CustomerService.postNewUserWithoutLastName();
	}

	@Test
	public void newUserWithInvalidMobile() {
		AuthService.getToken();
		CustomerService.postNewUserWithInvalidMobile();
	}
}
