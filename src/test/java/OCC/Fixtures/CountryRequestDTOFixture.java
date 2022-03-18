package OCC.Fixtures;

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

	public CountryRequestDTOFixture brazil() {
		countryDTO.setIsocode("BR");
		return this;
	}

}
