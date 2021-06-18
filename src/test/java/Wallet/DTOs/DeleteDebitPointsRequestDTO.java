package Wallet.DTOs;

import Wallet.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DeleteDebitPointsRequestDTO {

	private String transactionId;

	public static DeleteDebitPointsRequestDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, DeleteDebitPointsRequestDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public static DeleteDebitPointsRequestDTO build() {
		DeleteDebitPointsRequestDTO dto = new DeleteDebitPointsRequestDTO();
		dto.setTransactionId(Utils.getTRANSACTION_ID());
		return dto;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}

