package OCC.Fixtures;

import OCC.DTOs.RegionDTO;

public class RegionDTOFixture {

	private RegionDTO regionDTO;

	public RegionDTOFixture() {
		regionDTO = new RegionDTO();
	}

	public RegionDTO build() {
		return regionDTO;
	}

	public RegionDTOFixture stateRS() {
		regionDTO.setCountryIso(new CountryDTOFixture().brazil().build().getIsocode());
		regionDTO.setIsocode("BR-RS");
		regionDTO.setIsocodeShort("RS");
		regionDTO.setName("Rio Grande do Sul");
		return this;
	}

	public RegionDTOFixture stateSP() {
		regionDTO.setCountryIso(new CountryDTOFixture().build().getIsocode());
		regionDTO.setIsocode("BR-SP");
		regionDTO.setIsocodeShort("SP");
		regionDTO.setName("São Paulo");
		return this;
	}
}
