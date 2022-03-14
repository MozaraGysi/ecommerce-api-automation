package OCC.Tests;

import OCC.Services.AuthorizationPage;
import OCC.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorizationTest {

    @BeforeEach
    public void init() {
        Utils.init();
    }

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