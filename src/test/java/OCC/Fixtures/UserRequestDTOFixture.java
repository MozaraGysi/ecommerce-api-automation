package OCC.Fixtures;

import OCC.DTOs.Request.UserRequestDTO;
import OCC.Utils.Utils;

public final class UserRequestDTOFixture {

	private UserRequestDTO userDTO;

	private UserRequestDTOFixture() {
		userDTO = new UserRequestDTO();
	}

	public static UserRequestDTOFixture get() {
		return new UserRequestDTOFixture();
	}

	public UserRequestDTO build() {
		return userDTO;
	}

	public UserRequestDTOFixture getAutomationUser() {
		UserRequestDTO userRegister = UserRegisterRequestDTOFixture.get().automationUser().build();

		userDTO = new UserRequestDTO();
		userDTO.setFirstName(userRegister.getFirstName());
		userDTO.setLastName(userRegister.getLastName());
		userDTO.setPassword(userRegister.getPassword());
		userDTO.setUid(userRegister.getUid());
		userDTO.setGenderCode(userRegister.getGenderCode());
		userDTO.setBirthday("01/06/1985");
		userDTO.setMobilePhone("(51) 99743-5572");

		return this;
	}

	public UserRequestDTOFixture addBirthday() {
		userDTO.setBirthday("01/06/1985");
		return this;
	}

	public UserRequestDTOFixture addMobilePhone() {
		userDTO.setMobilePhone("(51) 99743-5572");
		return this;
	}

	public UserRequestDTOFixture addCpf() {
		userDTO.setCpf(Utils.cpf());
		return this;
	}
}
