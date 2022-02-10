package OCC.Tests;

import OCC.Services.AuthorizationPage;
import OCC.Services.HomePage;
import org.junit.jupiter.api.Test;

public class HomePageComponentsTest {

    @Test
    public void showHomePageComponents(){
        AuthorizationPage.AnonymousAuth();
        HomePage.GET_searchHomePageComponents();

    }
}
