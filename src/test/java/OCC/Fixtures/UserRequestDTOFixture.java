package OCC.Fixtures;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

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

	private UserRequestDTOFixture random() {
		return this
		.withFirstName(RandomStringUtils.random(5, true, false))
		.withLastName(RandomStringUtils.random(5, true, false))
		.withPassword(RandomStringUtils.random(5))
		.withUid(Utils.email())
		.withGenderCode(RandomUtils.nextBoolean() ? "MALE":"FEMALE")
		.withBirthday(RandomStringUtils.randomNumeric(8))
		.withMobilePhone(RandomStringUtils.randomNumeric(11));
	}

	public static UserRequestDTOFixture getRandom() {
		return UserRequestDTOFixture.get().random();
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

	public UserRequestDTOFixture withFirstName(String firstName){
		userDTO.setFirstName(firstName);
		return this;
	}

	public UserRequestDTOFixture withLastName(String lastName){
		userDTO.setLastName(lastName);
		return this;
	}

	public UserRequestDTOFixture withPassword(String password){
		userDTO.setPassword(password);
		return this;
	}

	public UserRequestDTOFixture withGenderCode(String genderCode){
		userDTO.setGenderCode(genderCode);
		return this;
	}

	public UserRequestDTOFixture withUid(String uid){
		userDTO.setUid(uid);
		return this;
	}

	public UserRequestDTOFixture withBirthday(String birthday){
		userDTO.setBirthday(birthday);
		return this;
	}
	public UserRequestDTOFixture withMobilePhone(String mobilePhone){
		userDTO.setMobilePhone(mobilePhone);
		return this;
	}

}
