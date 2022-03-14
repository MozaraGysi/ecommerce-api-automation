package OCC.Tests;

import OCC.Services.AuthorizationPage;
import OCC.Services.HomePage;
import OCC.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageComponentsTest {

    @BeforeEach
    public void init() {
        Utils.init();
    }

    @Test
    public void showHomePageComponents(){
        AuthorizationPage.AnonymousAuth();
        HomePage.GET_searchHomePageComponents();

    }
}
