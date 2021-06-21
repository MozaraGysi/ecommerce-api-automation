package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ErrorMessageResponseDTO {

	private String code;
	private String message;

	public static ErrorMessageResponseDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, ErrorMessageResponseDTO.class);
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
