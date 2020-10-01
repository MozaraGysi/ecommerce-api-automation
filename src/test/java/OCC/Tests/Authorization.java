package OCC.Tests;

import OCC.Pages.AuthorizationPage;
import org.junit.Test;

public class Authorization {
    
    @Test
    public void CustomerAuth()
    {
        AuthorizationPage.CustomerToken();
    }

    @Test
    public void AnonymousAuth()
    {
        AuthorizationPage.AnonymousAuth();
    }

    @Test
    public void RegisterCustomerAppleID()
    {
        AuthorizationPage.RegisterCustomerAppleID();
    }

    @Test
    public void RegisterCustomerfacebook(){ AuthorizationPage.RegisterCustomerFacebook(); }
}