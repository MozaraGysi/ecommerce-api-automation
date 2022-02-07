package Wallet.DTOs;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

public class DeleteDebitPointsResponseDTO extends AbstractDTO<DeleteDebitPointsResponseDTO> {

	private String transactionId;

	@Override
	public DeleteDebitPointsResponseDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}
