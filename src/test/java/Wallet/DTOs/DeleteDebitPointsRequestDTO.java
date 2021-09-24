package Wallet.DTOs;

import Wallet.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DeleteDebitPointsRequestDTO {

	private String transactionId;
	private float amount;
	private String dateTime;

	public static DeleteDebitPointsRequestDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, DeleteDebitPointsRequestDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
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
