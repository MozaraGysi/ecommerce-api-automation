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
    public void getSearchStoresByPostalCodeTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchPostalCode();
    }

    @Test
    public void getSearchStoresByCoordinatesTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchCoordinates();
    }

    @Test
    public void getSearchStoresByWrongPostalCodeTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchWrongPostalCode();
    }

    @Test
    public void getSearchStoresByAddressTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchAddress();
    }

}
