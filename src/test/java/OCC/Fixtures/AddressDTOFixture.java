package OCC.Fixtures;

import OCC.DTOs.AddressDTO;
import OCC.DTOs.UserDTO;

public class AddressDTOFixture {

	private AddressDTO addressDTO;

	public AddressDTOFixture() {
		addressDTO = new AddressDTO();
	}

	public AddressDTO build() {
		return addressDTO;
	}

	public AddressDTOFixture addressRS() {
		UserDTO user = new UserDTOFixture().getAutomationUser().build();

		addressDTO.setAddressName("Casa");
		addressDTO.setComplement("ap 414");
		addressDTO.setCountry(new CountryDTOFixture().brazil().build());
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
		addressDTO.setRegion(new RegionDTOFixture().stateRS().build());

		return this;
	}

	public AddressDTOFixture addressSP() {
		UserDTO user = new UserDTOFixture().getAutomationUser().build();

		addressDTO.setAddressName("Casa");
		addressDTO.setComplement("ap 414");
		addressDTO.setCountry(new CountryDTOFixture().brazil().build());
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
		addressDTO.setRegion(new RegionDTOFixture().stateSP().build());

		return this;
	}
}
