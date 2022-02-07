package OCC.Scenarios;

import OCC.Services.AuthorizationPage;
import OCC.Services.HomePage;
import org.junit.jupiter.api.Test;

public class HomePageComponents {

    @Test
    public void showHomePageComponents(){
        AuthorizationPage.AnonymousAuth();
        HomePage.GET_searchHomePageComponents();

    }
}
