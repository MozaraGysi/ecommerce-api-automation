package OCC.Fixtures;

import OCC.DTOs.UserDTO;
import OCC.DTOs.UserRegisterDTO;
import OCC.Utils.Utils;

public class UserDTOFixture {

	private UserDTO userDTO;

	public UserDTOFixture() {
		userDTO = new UserDTO();
	}

	public UserDTO build() {
		return userDTO;
	}

	public UserDTOFixture getAutomationUser() {
		UserRegisterDTO userRegister = new UserRegisterDTOFixture().automationUser().build();

		userDTO = new UserDTO();
		userDTO.setFirstName(userRegister.getFirstName());
		userDTO.setLastName(userRegister.getLastName());
		userDTO.setPassword(userRegister.getPassword());
		userDTO.setUid(userRegister.getUid());
		userDTO.setGenderCode(userRegister.getGenderCode());
		userDTO.setBirthday("01/06/1985");
		userDTO.setMobilePhone("(51) 99743-5572");

		return this;
	}

	public UserDTOFixture addBirthday() {
		userDTO.setBirthday("01/06/1985");
		return this;
	}

	public UserDTOFixture addMobilePhone() {
		userDTO.setMobilePhone("(51) 99743-5572");
		return this;
	}

	public UserDTOFixture addCpf() {
		userDTO.setCpf(Utils.cpf());
		return this;
	}
}
