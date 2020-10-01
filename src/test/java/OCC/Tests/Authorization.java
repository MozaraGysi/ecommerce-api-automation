package OCC.Tests;

import OCC.Pages.AuthorizationPage;
import OCC.Utils;
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
}