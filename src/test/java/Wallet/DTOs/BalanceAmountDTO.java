package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class BalanceAmountDTO {

	private float amount;
	private float pending_earnings;
	private float pending_redeems;

	public static BalanceAmountDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, BalanceAmountDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getPending_earnings() {
		return pending_earnings;
	}

	public void setPending_earnings(float pending_earnings) {
		this.pending_earnings = pending_earnings;
	}

	public float getPending_redeems() {
		return pending_redeems;
	}

	public void setPending_redeems(float pending_redeems) {
		this.pending_redeems = pending_redeems;
	}
}
