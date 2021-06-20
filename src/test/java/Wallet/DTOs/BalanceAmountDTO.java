package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class BalanceAmountDTO {

	private float available;
	private float pendingCredits;
	private float pendingDebits;
	private String lastDateTime;

	public static BalanceAmountDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, BalanceAmountDTO.class);
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

	public float getPendingCredits() {
		return pendingCredits;
	}

	public void setPendingCredits(float pendingCredits) {
		this.pendingCredits = pendingCredits;
	}

	public float getPendingDebits() {
		return pendingDebits;
	}

	public void setPendingDebits(float pendingDebits) {
		this.pendingDebits = pendingDebits;
	}

	public String getLastDateTime() {
		return lastDateTime;
	}

	public void setLastDateTime(String lastDateTime) {
		this.lastDateTime = lastDateTime;
	}
}
