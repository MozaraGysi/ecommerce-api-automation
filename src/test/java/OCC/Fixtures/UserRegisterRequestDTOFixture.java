package OCC.Fixtures;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

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

	private UserRegisterRequestDTOFixture random() {
		return this
		.withFirstName(RandomStringUtils.random(5, true, false))
		.withLastName(RandomStringUtils.random(6, true, false))
		.withPassword(RandomStringUtils.random(10))
		.withGenderCode(RandomUtils.nextBoolean() ? "MALE":"FEMALE")
		.withUid(Utils.email());
	}

	public static UserRegisterRequestDTOFixture getRandom() {
		return UserRegisterRequestDTOFixture.get().random();
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

	public UserRegisterRequestDTOFixture withFirstName(String firstName){
		userRequestDTO.setFirstName(firstName);
		return this;
	}

	public UserRegisterRequestDTOFixture withLastName(String lastName){
		userRequestDTO.setLastName(lastName);
		return this;
	}

	public UserRegisterRequestDTOFixture withPassword(String password){
		userRequestDTO.setPassword(password);
		return this;
	}

	public UserRegisterRequestDTOFixture withGenderCode(String genderCode){
		userRequestDTO.setGenderCode(genderCode);
		return this;
	}

	public UserRegisterRequestDTOFixture withUid(String uid){
		userRequestDTO.setUid(uid);
		return this;
	}

}
