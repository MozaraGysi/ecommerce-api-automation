package OCC.DTOs;

public class RegionDTO extends AbstractDTO<RegionDTO> {

	private String isocode;
	private String isocodeShort;
	private String countryIso;
	private String name;

	public String getIsocode() {
		return isocode;
	}

	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}

	public String getIsocodeShort() {
		return isocodeShort;
	}

	public void setIsocodeShort(String isocodeShort) {
		this.isocodeShort = isocodeShort;
	}

	public String getCountryIso() {
		return countryIso;
	}

	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
