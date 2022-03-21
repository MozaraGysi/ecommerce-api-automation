package OCC.Fixtures;

import OCC.DTOs.Request.AddressRequestDTO;
import OCC.DTOs.Request.UserRequestDTO;

public final class AddressRequestDTOFixture {

	private AddressRequestDTO addressDTO;

	private AddressRequestDTOFixture() {
		addressDTO = new AddressRequestDTO();
	}

	public static AddressRequestDTOFixture get() {
		return new AddressRequestDTOFixture();
	}

	public AddressRequestDTO build() {
		return addressDTO;
	}

	public AddressRequestDTOFixture addressRS() {
		UserRequestDTO user = UserRequestDTOFixture.get().getAutomationUser().build();

		addressDTO.setAddressName("Casa");
		addressDTO.setComplement("ap 414");
		addressDTO.setCountry(CountryRequestDTOFixture.get().brazil().build());
		addressDTO.setDefaultAddress(false);
		addressDTO.setDistrict("Pinheiro");
		addressDTO.setFirstName(user.getFirstName());
		addressDTO.setLastName(user.getLastName());
		addressDTO.setLine1("Avenida Imperatriz Leopoldina");
		addressDTO.setLine2("2500");
		addressDTO.setPhone(user.getMobilePhone());
		addressDTO.setPostalCode("93042-082");
		addressDTO.setTown("São Leopoldo");
		addressDTO.setTitleCode("sr");
		addressDTO.setRegion(RegionRequestDTOFixture.get().stateRS().build());

		return this;
	}

	public AddressRequestDTOFixture addressSP() {
		UserRequestDTO user = UserRequestDTOFixture.get().getAutomationUser().build();

		addressDTO.setAddressName("Casa");
		addressDTO.setComplement("ap 414");
		addressDTO.setCountry(CountryRequestDTOFixture.get().brazil().build());
		addressDTO.setDefaultAddress(false);
		addressDTO.setDistrict("Avenida Paulista");
		addressDTO.setFirstName(user.getFirstName());
		addressDTO.setLastName(user.getLastName());
		addressDTO.setLine1("Rua centro");
		addressDTO.setLine2("2500");
		addressDTO.setPhone(user.getMobilePhone());
		addressDTO.setPostalCode("01311-100");
		addressDTO.setTown("São Paulo");
		addressDTO.setTitleCode("sr");
		addressDTO.setRegion(RegionRequestDTOFixture.get().stateSP().build());

		return this;
	}
}
