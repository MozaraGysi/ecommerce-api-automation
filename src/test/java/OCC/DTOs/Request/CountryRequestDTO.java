package OCC.DTOs.Request;

import Common.AbstractDTO;

public class CountryRequestDTO extends AbstractDTO<CountryRequestDTO> {

	private String isocode;

	public String getIsocode() {
		return isocode;
	}

	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}
}
