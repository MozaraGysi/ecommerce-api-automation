package OCC.Fixtures;


import OCC.DTOs.LoginPageRequestDTO;

public class LoginPageRequestDTOFixture {
    private LoginPageRequestDTO loginPageRequestDTO;

    public LoginPageRequestDTOFixture() {
        loginPageRequestDTO = new LoginPageRequestDTO();
    }

    public LoginPageRequestDTO build() {
        return loginPageRequestDTO;
    }

    public LoginPageRequestDTOFixture defaultRequestByEmail() {
        loginPageRequestDTO.setEmail("progjavaprog@gmail.com");
        return this;
    }

    public LoginPageRequestDTOFixture defaultRequestByWrongEmail() {
        loginPageRequestDTO.setEmail("progja.com");
        return this;
    }

    public LoginPageRequestDTOFixture defaultPasswordOptionRequestByEmail(){
        loginPageRequestDTO.setEmail("progjavaprog@gmail.com");
        loginPageRequestDTO.setCheckout(false);
        loginPageRequestDTO.setRecoveryOption("EMAIL");
        return this;
    }

    public LoginPageRequestDTOFixture defaultPasswordOptionRequestByWrongEmail(){
        loginPageRequestDTO.setEmail("proj.com");
        loginPageRequestDTO.setCheckout(false);
        loginPageRequestDTO.setRecoveryOption("EMAIL");
        return this;
    }

    public LoginPageRequestDTOFixture defaultRequestByWrongCode(){
        loginPageRequestDTO.setEmail("progjavaprog@gmail.com");
        loginPageRequestDTO.setCheckout(false);
        loginPageRequestDTO.setRecoveryOption("EMAIL");
        loginPageRequestDTO.setCode("123456");
        return this;
    }

    public LoginPageRequestDTOFixture defaultRequestByWrongToken(){
        loginPageRequestDTO.setCheckPassword("teste1234");
        loginPageRequestDTO.setCheckout(false);
        loginPageRequestDTO.setPassword("zero123@");
        loginPageRequestDTO.setToken("gu5efejfu4ht4t85h3u4bu3tbgyu3");
        return this;
    }
}
