package OCC.Tests;

import OCC.Services.AuthorizationPage;
import OCC.Services.CategoryPage;
import org.junit.jupiter.api.Test;

public class ProductsTest {

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
