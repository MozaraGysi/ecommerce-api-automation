package OCC.Tests;

import OCC.Services.AuthorizationPage;
import OCC.Services.CategoryPage;
import OCC.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsTest {

    @BeforeEach
    public void init() {
        Utils.init();
    }

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
