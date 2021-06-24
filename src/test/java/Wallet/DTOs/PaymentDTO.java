package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

public class PaymentDTO {

	private String type;
	private String amount;
	private String installments;
	private Map extra;

	public static PaymentDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, PaymentDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getInstallments() {
		return installments;
	}

	public void setInstallments(String installments) {
		this.installments = installments;
	}

	public Map getExtra() {
		return extra;
	}

	public void setExtra(Map extra) {
		this.extra = extra;
	}
}
