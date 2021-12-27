package Wallet.DTOs;

import Wallet.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DeleteDebitPointsRequestDTO extends AbstractWalletDTO<DeleteDebitPointsRequestDTO>{

	private String transactionId;
	private float amount;
	private String dateTime;

	@Override
	public DeleteDebitPointsRequestDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}

