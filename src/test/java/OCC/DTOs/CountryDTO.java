package OCC.DTOs;

import Common.AbstractDTO;

public class CountryDTO extends AbstractDTO<CountryDTO> {

	private String isocode;

	public String getIsocode() {
		return isocode;
	}

	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}
}
