package OCC.Scenarios;

import OCC.Services.AuthorizationPage;
import OCC.Services.CategoryPage;
import org.junit.jupiter.api.Test;

public class Products {

    @Test
    public void searchProductsByProductCode(){
        AuthorizationPage.AnonymousAuth();
        CategoryPage.GET_searchProductsByCode();
    }

    @Test
    public void searchProductsWithoutFilters(){
        AuthorizationPage.AnonymousAuth();
        CategoryPage.GET_searchProductsWithoutFilters();
    }
}
