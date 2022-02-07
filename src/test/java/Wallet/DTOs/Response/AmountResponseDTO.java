package Wallet.DTOs.Response;

import Wallet.DTOs.AbstractWalletDTO;
import com.google.gson.JsonObject;

public class AmountResponseDTO extends AbstractWalletDTO<AmountResponseDTO> {

	private float available;
	private float pendingDebit;
	private float pendingCredit;

	@Override
	public AmountResponseDTO fromJsonString(String jsonString) {
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
