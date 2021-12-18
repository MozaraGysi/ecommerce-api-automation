package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExpirePointsDTO {

	private String document;
	private Double amount;

	public static ExpirePointsDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, ExpirePointsDTO.class);
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
