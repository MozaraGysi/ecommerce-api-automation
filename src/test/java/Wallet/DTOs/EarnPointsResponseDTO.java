package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class EarnPointsResponseDTO {

	private String transactionId;

	public static EarnPointsResponseDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, EarnPointsResponseDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}
