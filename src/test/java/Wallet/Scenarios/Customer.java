package Wallet.Scenarios;

import Wallet.Services.AuthService;
import Wallet.Services.CustomerService;
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
		AuthService.getToken();
		CustomerService.newUser();
	}

	@Test
	public void newUserWithoutAuthentication() {
		CustomerService.newUserWithoutAuthentication();
	}

	@Test
	public void newUserWithoutCPF() {
		AuthService.getToken();
		CustomerService.newUserWithoutCPF();
	}

	@Test
	public void newUserWithInvalidCPF() {
		AuthService.getToken();
		CustomerService.newUserWithInvalidCPF();
	}

	@Test
	public void newUserWithoutFirstName() {
		AuthService.getToken();
		CustomerService.newUserWithoutFirstName();
	}

	@Test
	public void newUserWithoutLastName() {
		AuthService.getToken();
		CustomerService.newUserWithoutLastName();
	}

	@Test
	public void newUserWithInvalidMobile() {
		AuthService.getToken();
		CustomerService.newUserWithInvalidMobile();
	}

	@Test
	public void newUserWithoutFirstNameAndWithoutLastName() {
		AuthService.getToken();
		CustomerService.newUserWithoutFirstNameAndWithoutLastName();
	}
}
