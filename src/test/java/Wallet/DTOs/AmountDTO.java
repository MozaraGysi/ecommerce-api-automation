package Wallet.DTOs;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

public class AmountDTO extends AbstractDTO<AmountDTO> {

	private float available;
	private float pendingDebit;
	private float pendingCredit;

	@Override
	public AmountDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
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
