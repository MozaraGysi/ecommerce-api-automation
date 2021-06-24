package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class BalancePointsResponseDTO {

	private String document;
	private String lastDateTime;
	private AmountDTO amount;

	public static BalancePointsResponseDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, BalancePointsResponseDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
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
