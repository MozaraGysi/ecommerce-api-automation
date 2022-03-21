package OCC.Scenarios;

import OCC.Services.AuthorizationService;
import OCC.Services.LoginService;
import org.junit.jupiter.api.Test;

public class Login {

    @Test
    public void searchOptionsListByEmail(){
        AuthorizationService.AnonymousAuth();
        LoginService.getSearchOptionsListByEmail();
    }

    @Test
    public void searchOptionsListByWrongEmail(){
        AuthorizationService.AnonymousAuth();
        LoginService.getSearchOptionsListByWrongEmail();
    }

    @Test
    public void requestPasswordChangeByOption(){
        AuthorizationService.AnonymousAuth();
        LoginService.postRequestPasswordChangeByOption();
    }

    @Test
    public void requestPasswordChangeByWrongOption(){
        AuthorizationService.AnonymousAuth();
        LoginService.postRequestPasswordChangeByWrongOption();
    }

    @Test
    public void requestCheckReceivdCode(){
        AuthorizationService.AnonymousAuth();
        LoginService.getRequestCheckReceivedCode();
    }

    @Test
    public void requestChangePassword(){
        AuthorizationService.AnonymousAuth();
        LoginService.postRequestChangePassword();
    }
}
