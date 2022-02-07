package Wallet.DTOs.Response;

import com.google.gson.JsonObject;

public class DeleteCreditPointsResponseDTO extends AbstractWalletResponseDTO<DeleteCreditPointsResponseDTO> {

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
