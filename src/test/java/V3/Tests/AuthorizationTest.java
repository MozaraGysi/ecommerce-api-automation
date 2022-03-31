package V3.Tests;

import V3.Handlers.ValidateAuthorization;
import V3.Pages.AuthorizationPage;
import org.junit.jupiter.api.Test;

public class AuthorizationTest {

	@Test
	public void CustomerAuthentication() {
		String body = AuthorizationPage.getAuthorizationBody();
		ValidateAuthorization.CustomerAuthorizationValidation(body);
	}
}