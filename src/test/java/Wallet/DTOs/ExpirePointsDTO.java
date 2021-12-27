package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExpirePointsDTO extends AbstractWalletDTO<ExpirePointsDTO>{

	private String document;
	private Double amount;

	@Override
	public ExpirePointsDTO fromJsonString(String jsonString) {
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
