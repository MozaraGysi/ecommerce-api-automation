package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class BalancePointsResponseDTO extends AbstractWalletDTO<BalancePointsResponseDTO> {

	private String document;
	private String lastDateTime;
	private AmountDTO amount;

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

	public AmountDTO getAmount() {
		return amount;
	}

	public void setAmount(AmountDTO amount) {
		this.amount = amount;
	}
}
