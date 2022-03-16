package OCC.Tests;

import OCC.Services.AuthorizationService;
import OCC.Services.HomeService;
import OCC.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeServiceComponentsTest {

    @BeforeEach
    public void init() {
        Utils.init();
    }

    @Test
    public void getShowHomePageComponents(){
        AuthorizationService.AnonymousAuth();
        HomeService.getSearchHomePageComponents();

    }
}
