package OCC.Tests;

import OCC.Services.AuthorizationService;
import OCC.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static OCC.Data.OCCDataTest.*;

public class AuthorizationTest {

    @BeforeEach
    public void init() {
        Utils.init();
    }

    @Test
    public void CustomerAuth()
    {
        AuthorizationService.CustomerToken();
    }

    @Test
    public void AnonymousAuth() { AuthorizationService.AnonymousAuth(); }

    @Test
    public void RegisterCustomerAppleID()
    {
        AuthorizationService.RegisterCustomerAppleID();
    }

    @Test
    public void RegisterCustomerfacebook(){ AuthorizationService.RegisterCustomerFacebook(); }

}