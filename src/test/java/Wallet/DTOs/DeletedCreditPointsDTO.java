package Wallet.DTOs;

import Wallet.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DeletedCreditPointsDTO {

	private String transactionId;

	public static DeletedCreditPointsDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, DeletedCreditPointsDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public static DeletedCreditPointsDTO build() {
		DeletedCreditPointsDTO dto = new DeletedCreditPointsDTO();
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
