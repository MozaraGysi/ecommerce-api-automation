package OCC.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ProductDTO {

	private String code;

	public static ProductDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, ProductDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
