package OCC.Fixtures;

import OCC.DTOs.Request.UserRequestDTO;
import OCC.Utils.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.RandomUtils.nextInt;

public final class UserRegisterRequestDTOFixture {

	private UserRequestDTO userRequestDTO;

	private UserRegisterRequestDTOFixture() {
		this.userRequestDTO = new UserRequestDTO();
	}

	public static UserRegisterRequestDTOFixture get(){
		return new UserRegisterRequestDTOFixture();
	}

	public static UserRegisterRequestDTOFixture getRandom() {
		return UserRegisterRequestDTOFixture.get().random();
	}

	public static List<UserRequestDTO> buildRandomList(int quantity) {
		return IntStream
			.range(0, quantity)
			.mapToObj(x -> UserRegisterRequestDTOFixture.get().random().build())
			.collect(Collectors.toList());
	}

	public static List<UserRequestDTO> buildRandomList() {
		return buildRandomList(nextInt(1, 10));
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
