package OCC.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CountryDTO {

	private String isocode;

	public static CountryDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, CountryDTO.class);
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
}
