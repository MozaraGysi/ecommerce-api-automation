package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DebitPointsResponseDTO extends AbstractWalletDTO<DebitPointsResponseDTO>{

	private String transactionId;

	@Override
	public DebitPointsResponseDTO fromJsonString(String jsonString) {
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
