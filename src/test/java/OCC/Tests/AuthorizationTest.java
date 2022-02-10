package OCC.Tests;

import OCC.Services.AuthorizationPage;
import org.junit.jupiter.api.Test;

public class AuthorizationTest {
    
    @Test
    public void CustomerAuth()
    {
        AuthorizationPage.CustomerToken();
    }

    @Test
    public void AnonymousAuth() { AuthorizationPage.AnonymousAuth(); }

    @Test
    public void RegisterCustomerAppleID()
    {
        AuthorizationPage.RegisterCustomerAppleID();
    }

    @Test
    public void RegisterCustomerfacebook(){ AuthorizationPage.RegisterCustomerFacebook(); }

}