package Wallet.DTOs;

import Wallet.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DeletedPointsDTO {

	private String transactionId;

	public static DeletedPointsDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, DeletedPointsDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public static DeletedPointsDTO build() {
		DeletedPointsDTO dto = new DeletedPointsDTO();
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
