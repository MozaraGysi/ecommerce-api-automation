package OCC.Fixtures;

import OCC.DTOs.CountryDTO;

public class CountryDTOFixture {

	private CountryDTO countryDTO;

	public CountryDTOFixture() {
		countryDTO = new CountryDTO();
	}

	public CountryDTO build() {
		return countryDTO;
	}

	public CountryDTOFixture brazil() {
		countryDTO.setIsocode("BR");
		return this;
	}

}
