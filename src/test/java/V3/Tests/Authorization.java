package V3.Tests;

import V3.APIHandle.ValidateAuthorization;
import V3.Pages.AuthorizationPage;
import org.junit.jupiter.api.Test;

public class Authorization {

    @Test
    public void CustomerAuthentication()
    {
        String Body = AuthorizationPage.CustomerToken();
        ValidateAuthorization.CustomerAuthorizationValidation(Body);
    }
}