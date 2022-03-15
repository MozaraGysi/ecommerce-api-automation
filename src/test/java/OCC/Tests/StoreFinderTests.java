package OCC.Tests;

import OCC.Services.AuthorizationService;
import OCC.Services.StoreFinderService;
import OCC.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoreFinderTests {

    @BeforeEach
    public void init() {
        Utils.init();
    }

    @Test
    public void searchStoresByPostalCodeTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchPostalCode();
    }

    @Test
    public void searchStoresByCoordinatesTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchCoordinates();
    }

    @Test
    public void searchStoresByWrongPostalCodeTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchWrongPostalCode();
    }

    @Test
    public void searchStoresByAddressTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchAddress();
    }

}
