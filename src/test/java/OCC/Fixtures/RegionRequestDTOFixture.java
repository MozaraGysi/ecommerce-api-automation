package OCC.Fixtures;

import org.apache.commons.lang3.RandomStringUtils;

import OCC.DTOs.Request.RegionRequestDTO;

public final class RegionRequestDTOFixture {

	private RegionRequestDTO regionDTO;

	private RegionRequestDTOFixture() {
		regionDTO = new RegionRequestDTO();
	}

	public static RegionRequestDTOFixture get(){
		return new RegionRequestDTOFixture();
	}

	public RegionRequestDTO build() {
		return regionDTO;
	}

	private RegionRequestDTOFixture random() {
		return this
		.withCountryIso(CountryRequestDTOFixture.get().brazil().build().getIsocode())
		.withIsocode(RandomStringUtils.random(2, true, false) + "-" + RandomStringUtils.random(2, true, false))
		.withIsocodeShort(RandomStringUtils.random(2, true, false))
		.withName(RandomStringUtils.random(10, true, false));
	}

	public static RegionRequestDTOFixture getRandom() {
		return RegionRequestDTOFixture.get().random();
	}

	public RegionRequestDTOFixture stateRS() {
		regionDTO.setCountryIso(CountryRequestDTOFixture.get().brazil().build().getIsocode());
		regionDTO.setIsocode("BR-RS");
		regionDTO.setIsocodeShort("RS");
		regionDTO.setName("Rio Grande do Sul");
		return this;
	}

	public RegionRequestDTOFixture stateSP() {
		regionDTO.setCountryIso(CountryRequestDTOFixture.get().build().getIsocode());
		regionDTO.setIsocode("BR-SP");
		regionDTO.setIsocodeShort("SP");
		regionDTO.setName("São Paulo");
		return this;
	}

	public RegionRequestDTOFixture withCountryIso(String countryIso){
		regionDTO.setCountryIso(countryIso);
		return this;
	}

	public RegionRequestDTOFixture withIsocode(String isocode){
		regionDTO.setIsocode(isocode);
		return this;
	}

	public RegionRequestDTOFixture withIsocodeShort(String isocodeShort){
		regionDTO.setIsocodeShort(isocodeShort);
		return this;
	}

	public RegionRequestDTOFixture withName(String name){
		regionDTO.setName(name);
		return this;
	}

}
