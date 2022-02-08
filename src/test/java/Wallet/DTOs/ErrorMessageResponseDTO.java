package Wallet.DTOs;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

public class ErrorMessageResponseDTO extends AbstractDTO<ErrorMessageResponseDTO> {

	private String code;
	private String message;

	@Override
	public ErrorMessageResponseDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
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
