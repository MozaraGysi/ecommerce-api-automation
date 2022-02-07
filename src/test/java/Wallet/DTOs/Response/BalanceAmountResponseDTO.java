package Wallet.DTOs.Response;

import Wallet.DTOs.AbstractWalletDTO;
import com.google.gson.JsonObject;

public class BalanceAmountResponseDTO extends AbstractWalletDTO<BalanceAmountResponseDTO> {

	private float available;
	private float pendingCredits;
	private float pendingDebits;
	private String lastDateTime;

	@Override
	public BalanceAmountResponseDTO fromJsonString(String jsonString) {
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
