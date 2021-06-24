package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DeleteCreditPointsResponseDTO {

	private String transactionId;

	public static DeleteCreditPointsResponseDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, DeleteCreditPointsResponseDTO.class);
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
