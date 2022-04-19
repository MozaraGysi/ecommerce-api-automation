package OCC.Tests;

import Common.Utils.IgnoreZzmall;
import OCC.Services.AuthorizationService;
import OCC.Services.StoreFinderService;
import OCC.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@IgnoreZzmall
public class StoreFinderTests {

    @BeforeEach
    public void init() {
        Utils.init();
    }

    @Test
    public void getSearchStoresByPostalCodeIsAnonymousUserTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchPostalCode();
    }

    @Test
    public void getSearchStoresByPostalCodeIsLoggedUserTest(){
        AuthorizationService.CustomerToken();
        StoreFinderService.getSearchPostalCode();
    }

    @Test
    public void getSearchStoresByCoordinatesIsAnonymousUserTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchCoordinates();
    }

    @Test
    public void getSearchStoresByCoordinatesIsLoggedUserTest(){
        AuthorizationService.CustomerToken();
        StoreFinderService.getSearchCoordinates();
    }

    @Test
    public void getSearchStoresByWrongPostalCodeIsAnonymousUserTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchWrongPostalCode();
    }

    @Test
    public void getSearchStoresByWrongPostalCodeIsLoggedUserTest(){
        AuthorizationService.CustomerToken();
        StoreFinderService.getSearchWrongPostalCode();
    }

    @Test
    public void getSearchStoresByAddressAnonymousAuthTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchAddress();
    }

    @Test
    public void getSearchStoresByAddressIsLoggedUserTest(){
        AuthorizationService.CustomerToken();
        StoreFinderService.getSearchAddress();
    }

    @Test
    public void getSearchStoresByWrongAddressAnonymousAuthTest(){
        AuthorizationService.AnonymousAuth();
        StoreFinderService.getSearchWrongAddress();
    }

    @Test
    public void getSearchStoresByWrongAddressIsLoggedUserTest(){
        AuthorizationService.CustomerToken();
        StoreFinderService.getSearchWrongAddress();
    }
}
