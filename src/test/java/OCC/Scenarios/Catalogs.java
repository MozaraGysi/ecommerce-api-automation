package OCC.Scenarios;

import OCC.Services.AuthorizationPage;
import OCC.Services.CategoryPage;
import org.junit.jupiter.api.Test;

public class Catalogs {

    @Test
    public void CategoryTestName(){
        AuthorizationPage.AnonymousAuth();
        CategoryPage.GET_searchName();
    }
    @Test
    public void CategoryTestValue(){
        AuthorizationPage.AnonymousAuth();
        CategoryPage.GET_searchValue();
    }
    @Test
    public void CategoryTestImage(){
        AuthorizationPage.AnonymousAuth();
        CategoryPage.GET_searchImages();
    }
}
