package OCC.Fixtures;

import OCC.DTOs.UserRegisterDTO;
import OCC.Utils.Utils;

public class UserRegisterDTOFixture {

	private UserRegisterDTO userRegisterDTO;

	public UserRegisterDTOFixture() {
		userRegisterDTO = new UserRegisterDTO();
	}

	public UserRegisterDTO build() {
		return userRegisterDTO;
	}

	public UserRegisterDTOFixture automationUser() {
		userRegisterDTO = new UserRegisterDTO();
		userRegisterDTO.setFirstName("Automation");
		userRegisterDTO.setLastName("User");
		userRegisterDTO.setPassword("zero123@");
		userRegisterDTO.setGenderCode("MALE");
		return this;
	}

	public UserRegisterDTOFixture addEmail() {
		userRegisterDTO.setUid(Utils.email());
		return this;
	}
}
