package Wallet.DTOs.Response;

import com.google.gson.JsonObject;

public class BalancePointsResponseDTO extends AbstractWalletResponseDTO<BalancePointsResponseDTO> {

	private String document;
	private String lastDateTime;
	private AmountResponseDTO amount;

	@Override
	public BalancePointsResponseDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getLastDateTime() {
		return lastDateTime;
	}

	public void setLastDateTime(String lastDateTime) {
		this.lastDateTime = lastDateTime;
	}

	public AmountResponseDTO getAmount() {
		return amount;
	}

	public void setAmount(AmountResponseDTO amount) {
		this.amount = amount;
	}
}
