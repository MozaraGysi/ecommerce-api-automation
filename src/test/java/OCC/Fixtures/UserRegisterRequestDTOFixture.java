package OCC.Fixtures;

import OCC.DTOs.Request.AuthorizationRequestDTO;
import OCC.DTOs.Request.UserRequestDTO;
import OCC.Utils.Utils;

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

	public UserRegisterRequestDTOFixture random() {
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
