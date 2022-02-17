package OCC.Scenarios;

import OCC.Services.AuthorizationPage;
import OCC.Services.StoreFinderPage;
import org.junit.jupiter.api.Test;

public class StoreFinder {

    @Test
    public void searchStoresByPostalCode(){
        AuthorizationPage.AnonymousAuth();
        StoreFinderPage.GET_searchPostalcode();
    }

    @Test
    public void searchStoresByCoordinates(){
        AuthorizationPage.AnonymousAuth();
        StoreFinderPage.GET_searchCoordinates();
    }

    @Test
    public void searchStoresByWrongPostalCode(){
        AuthorizationPage.AnonymousAuth();
        StoreFinderPage.GET_searchWrongPostalCode();
    }

    @Test
    public void searchStoresByAddress(){
        AuthorizationPage.AnonymousAuth();
        StoreFinderPage.GET_searchAddress();
    }

}
