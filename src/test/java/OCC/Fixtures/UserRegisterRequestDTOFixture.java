package OCC.Fixtures;

import OCC.DTOs.Request.UserRequestDTO;
import OCC.Utils.Utils;

public final class UserRegisterRequestDTOFixture {

	private UserRequestDTO userRequestDTO;

	private UserRegisterRequestDTOFixture() {
		userRequestDTO = new UserRequestDTO();
	}

	public static UserRegisterRequestDTOFixture get(){
		return new UserRegisterRequestDTOFixture();
	}

	public UserRequestDTO build() {
		return userRequestDTO;
	}

	public UserRegisterRequestDTOFixture automationUser() {
		userRequestDTO = new UserRequestDTO();
		userRequestDTO.setFirstName("Automation");
		userRequestDTO.setLastName("User");
		userRequestDTO.setPassword("zero123@");
		userRequestDTO.setGenderCode("MALE");
		return this;
	}

	public UserRegisterRequestDTOFixture addEmail() {
		userRequestDTO.setUid(Utils.email());
		return this;
	}
}
