package OCC.DTOs;

public class LoginPageRequestDTO extends AbstractDTO<LoginPageRequestDTO> {

    private String email;
    private boolean isCheckout;
    private String recoveryOption;
    private String code;
    private String checkPassword;
    private String password;
    private String token;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCheckout() {
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    public String getRecoveryOption() {
        return recoveryOption;
    }

    public void setRecoveryOption(String recoveryOption) {
        this.recoveryOption = recoveryOption;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
