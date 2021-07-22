package OCC.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class RegionDTO {

	private String isocode;
	private String isocodeShort;
	private String countryIso;
	private String name;

	public static RegionDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, RegionDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

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
