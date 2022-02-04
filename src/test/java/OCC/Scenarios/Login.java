package OCC.Scenarios;

import OCC.Services.AuthorizationPage;
import OCC.Services.LoginPage;
import org.junit.jupiter.api.Test;

public class Login {

    @Test
    public void searchOptionsByEmail(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.GET_searchListByEmail();
    }

    @Test
    public void searchOptionsByWrongEmail(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.GET_searchListByWrongEmail();
    }

    @Test
    public void requestPasswordChangeByOption(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.POST_searchRequestPasswordChangeByOption();
    }

    @Test
    public void requestPasswordChangeByOptionWrong(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.POST_searchRequestPasswordChangeByWrongOption();
    }

    @Test
    public void requestCheckReceivdCode(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.GET_requestCheckReceivdCode();
    }

    @Test
    public void requestChangePassword(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.POST_requestChangePassword();
    }
}
