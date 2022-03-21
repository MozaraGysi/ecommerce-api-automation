package OCC.Fixtures;

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
}
