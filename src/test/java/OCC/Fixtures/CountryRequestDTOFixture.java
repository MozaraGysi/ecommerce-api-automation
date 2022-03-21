package OCC.Fixtures;

<<<<<<< HEAD
import org.apache.commons.lang.RandomStringUtils;

=======
>>>>>>> f2ca54f00b782af78a4320ea8eb7a56766cbcdbc
import OCC.DTOs.Request.CountryRequestDTO;

public final class CountryRequestDTOFixture {

	private CountryRequestDTO countryDTO;

	private CountryRequestDTOFixture() {
		countryDTO = new CountryRequestDTO();
	}

	public static CountryRequestDTOFixture get() {
		return new CountryRequestDTOFixture();
	}

	public CountryRequestDTO build() {
		return countryDTO;
	}

	private CountryRequestDTOFixture random() {
		return this
		.withIsocode(RandomStringUtils.random(2, true, false));
	}

	public static CountryRequestDTOFixture getRandom() {
		return CountryRequestDTOFixture.get().random();
	}

	public CountryRequestDTOFixture withIsocode(String isocode) {
		countryDTO.setIsocode(isocode);
		return this;
	}

	public CountryRequestDTOFixture brazil() {
		countryDTO.setIsocode("BR");
		return this;
	}

}
