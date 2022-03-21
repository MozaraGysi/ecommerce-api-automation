package OCC.DTOs.Response;

import Common.AbstractDTO;

public class CountryResponseDTO extends AbstractDTO<CountryResponseDTO> {

	private String isocode;

	public String getIsocode() {
		return isocode;
	}

	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}
}
