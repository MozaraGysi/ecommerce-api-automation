package Wallet.DTOs.Response;

import Wallet.DTOs.AbstractWalletDTO;
import com.google.gson.JsonObject;

public class DeleteCreditPointsResponseDTO extends AbstractWalletDTO<DeleteCreditPointsResponseDTO> {

	private String transactionId;

	@Override
	public DeleteCreditPointsResponseDTO fromJsonString(String jsonString) {
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
