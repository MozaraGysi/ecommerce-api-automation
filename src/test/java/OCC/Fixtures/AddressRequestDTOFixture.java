package OCC.Fixtures;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import OCC.DTOs.Request.AddressRequestDTO;
import OCC.DTOs.Request.CountryRequestDTO;
import OCC.DTOs.Request.RegionRequestDTO;
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

	private AddressRequestDTOFixture random() {
		return this
		.withAddressName(RandomStringUtils.random(5, true, false))
		.withComplement(RandomStringUtils.random(5, true, true))
		.withCountry(CountryRequestDTOFixture.getRandom().build())
		.withDefaultAddress(RandomUtils.nextBoolean())
		.withDistrict(RandomStringUtils.random(5, true, true))
		.withFirstName(RandomStringUtils.random(5, true, false))
		.withLastName(RandomStringUtils.random(5, true, false))
		.withLine1(RandomStringUtils.random(5, true, false))
		.withLine2(RandomStringUtils.random(5, false, true))
		.withPhone(RandomStringUtils.randomNumeric(11))
		.withPostalCode(RandomStringUtils.randomNumeric(7))
		.withTown(RandomStringUtils.random(8, true, false))
		.withTitleCode(RandomStringUtils.random(2, true, false))
		.withRegion(RegionRequestDTOFixture.getRandom().build());
	}

	public static AddressRequestDTOFixture getRandom() {
		return AddressRequestDTOFixture.get().random();
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

		public AddressRequestDTOFixture withAddressName(String addressName){
			addressDTO.setAddressName(addressName);
			return this;
		}
		public AddressRequestDTOFixture withComplement(String complement){
			addressDTO.setComplement(complement);
			return this;
		}
		public AddressRequestDTOFixture withCountry(CountryRequestDTO country){
			addressDTO.setCountry(country);
			return this;
		}
		public AddressRequestDTOFixture withDefaultAddress(Boolean defaultAddress){
			addressDTO.setDefaultAddress(false);
			return this;
		}
		public AddressRequestDTOFixture withDistrict(String district){
			addressDTO.setDistrict(district);
			return this;
		}
		public AddressRequestDTOFixture withFirstName(String firstName){
			addressDTO.setFirstName(firstName);
			return this;
		}
		public AddressRequestDTOFixture withLastName(String lastName){
			addressDTO.setLastName(lastName);
			return this;
		}
		public AddressRequestDTOFixture withLine1(String line1){
			addressDTO.setLine1(line1);
			return this;
		}
		public AddressRequestDTOFixture withLine2(String line2){
			addressDTO.setLine2(line2);
			return this;
		}
		public AddressRequestDTOFixture withPhone(String phone){
			addressDTO.setPhone(phone);
			return this;
		}
		public AddressRequestDTOFixture withPostalCode(String postalCode){
			addressDTO.setPostalCode(postalCode);
			return this;
		}
		public AddressRequestDTOFixture withTown(String town){
			addressDTO.setTown(town);
			return this;
		}
		public AddressRequestDTOFixture withTitleCode(String titleCode){
			addressDTO.setTitleCode(titleCode);
			return this;
		}
		public AddressRequestDTOFixture withRegion(RegionRequestDTO region){
			addressDTO.setRegion(region);
			return this;
		}
}
