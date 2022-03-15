package OCC.Scenarios;

import OCC.Services.AuthorizationService;
import OCC.Services.LoginService;
import org.junit.jupiter.api.Test;

public class Login {

    @Test
    public void searchOptionsListByEmail(){
        AuthorizationService.AnonymousAuth();
        LoginService.GET_searchOptionsListByEmail();
    }

    @Test
    public void searchOptionsListByWrongEmail(){
        AuthorizationService.AnonymousAuth();
        LoginService.GET_searchOptionsListByWrongEmail();
    }

    @Test
    public void requestPasswordChangeByOption(){
        AuthorizationService.AnonymousAuth();
        LoginService.POST_RequestPasswordChangeByOption();
    }

    @Test
    public void requestPasswordChangeByWrongOption(){
        AuthorizationService.AnonymousAuth();
        LoginService.POST_RequestPasswordChangeByWrongOption();
    }

    @Test
    public void requestCheckReceivdCode(){
        AuthorizationService.AnonymousAuth();
        LoginService.GET_requestCheckReceivdCode();
    }

    @Test
    public void requestChangePassword(){
        AuthorizationService.AnonymousAuth();
        LoginService.POST_requestChangePassword();
    }
}
