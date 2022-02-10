package Wallet.DTOs.Response;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

import java.util.Map;

public class PaymentResponseDTO extends AbstractDTO<PaymentResponseDTO> {

	private String type;
	private String amount;
	private String installments;
	private Map extra;

	@Override
	public PaymentResponseDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
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
