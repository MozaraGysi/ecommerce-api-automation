package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AmountDTO {

	private float available;
	private float pendingDebit;
	private float pendingCredit;

	public static AmountDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, AmountDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public float getAvailable() {
		return available;
	}

	public void setAvailable(float available) {
		this.available = available;
	}

	public float getPendingDebit() {
		return pendingDebit;
	}

	public void setPendingDebit(float pendingDebit) {
		this.pendingDebit = pendingDebit;
	}

	public float getPendingCredit() {
		return pendingCredit;
	}

	public void setPendingCredit(float pendingCredit) {
		this.pendingCredit = pendingCredit;
	}
}
