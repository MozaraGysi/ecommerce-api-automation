package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DebitPointsResponseDTO {

	private String transactionId;

	public static DebitPointsResponseDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, DebitPointsResponseDTO.class);
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
