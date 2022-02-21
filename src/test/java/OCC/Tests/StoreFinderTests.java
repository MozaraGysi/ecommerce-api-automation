package OCC.Tests;

import OCC.Services.AuthorizationPage;
import OCC.Services.StoreFinderService;
import org.junit.jupiter.api.Test;

public class StoreFinderTests {

    @Test
    public void searchStoresByPostalCodeTest(){
        AuthorizationPage.AnonymousAuth();
        StoreFinderService.getSearchPostalCode();
    }

    @Test
    public void searchStoresByCoordinatesTest(){
        AuthorizationPage.AnonymousAuth();
        StoreFinderService.getSearchCoordinates();
    }

    @Test
    public void searchStoresByWrongPostalCodeTest(){
        AuthorizationPage.AnonymousAuth();
        StoreFinderService.getSearchWrongPostalCode();
    }

    @Test
    public void searchStoresByAddressTest(){
        AuthorizationPage.AnonymousAuth();
        StoreFinderService.getSearchAddress();
    }

}
