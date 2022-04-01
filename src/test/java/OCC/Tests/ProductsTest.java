package OCC.Tests;

import OCC.Services.AuthorizationService;
import OCC.Services.CategoryService;
import OCC.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static OCC.Data.OCCDataTest.*;

public class ProductsTest {

    @BeforeEach
    public void init() {
        Utils.init();
    }

    @Test
    public void getSearchProductsByProductCode(){
        AuthorizationService.AnonymousAuth();
        CategoryService.getSearchProductsByCode();
    }

    @Test
    public void getSearchProductsWithoutFilters(){
        AuthorizationService.AnonymousAuth();
        CategoryService.getSearchProductsWithoutFilters();
    }

    @Test
    public void getSearchProductsWithCodeFieldsAndPage(){
        AuthorizationService.AnonymousAuth();
        CategoryService.getSearchProductsByCodeFieldsAndPage(getProductPadrao(), FIELDS, PAGE);
    }

}
