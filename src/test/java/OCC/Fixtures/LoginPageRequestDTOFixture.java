package OCC.Fixtures;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import OCC.DTOs.Request.LoginPageRequestDTO;

public final class LoginPageRequestDTOFixture {

    private LoginPageRequestDTO loginPageRequestDTO;

    private LoginPageRequestDTOFixture() {
        loginPageRequestDTO = new LoginPageRequestDTO();
    }

    public static LoginPageRequestDTOFixture get(){
		return new LoginPageRequestDTOFixture();
	}

    public LoginPageRequestDTO build() {
        return loginPageRequestDTO;
    }

	private LoginPageRequestDTOFixture random() {
		return this
        .withEmail(RandomStringUtils.random(20, "@"))
        .withCheckout(RandomUtils.nextBoolean())
        .withRecoveryOption("EMAIL")
        .withCode(String.valueOf(RandomUtils.nextInt(100000, 999999)))
        .withToken(RandomStringUtils.random(20));
	}

	public static LoginPageRequestDTOFixture getRandom() {
		return LoginPageRequestDTOFixture.get().random();
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

    public LoginPageRequestDTOFixture withEmail(String email){
        loginPageRequestDTO.setEmail(email);
        return this;
    }

    public LoginPageRequestDTOFixture withCheckout(boolean checkout){
        loginPageRequestDTO.setCheckout(checkout);
        return this;
    }

    public LoginPageRequestDTOFixture withRecoveryOption(String recoveryOption){
        loginPageRequestDTO.setRecoveryOption(recoveryOption);
        return this;
    }

    public LoginPageRequestDTOFixture withCode(String code){
        loginPageRequestDTO.setCode(code);
        return this;
    }

    public LoginPageRequestDTOFixture withToken(String token){
        loginPageRequestDTO.setToken(token);
        return this;
    }

}
