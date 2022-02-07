package OCC.Scenarios;

import OCC.Services.AuthorizationPage;
import OCC.Services.LoginPage;
import org.junit.jupiter.api.Test;

public class Login {

    @Test
    public void searchOptionsListByEmail(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.GET_searchOptionsListByEmail();
    }

    @Test
    public void searchOptionsListByWrongEmail(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.GET_searchOptionsListByWrongEmail();
    }

    @Test
    public void requestPasswordChangeByOption(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.POST_RequestPasswordChangeByOption();
    }

    @Test
    public void requestPasswordChangeByWrongOption(){
        AuthorizationPage.AnonymousAuth();
        LoginPage.POST_RequestPasswordChangeByWrongOption();
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
