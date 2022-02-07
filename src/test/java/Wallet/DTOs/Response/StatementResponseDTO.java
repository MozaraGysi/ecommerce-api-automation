package Wallet.DTOs.Response;

import com.google.gson.JsonObject;

public class StatementResponseDTO extends AbstractWalletResponseDTO<StatementResponseDTO> {

	private String transactionId;
	private String cancelTransactionId;
	private float amount;
	private String type;
	private String status;
	private String dateTime;
	private String expireAt;
	private String description;
	private OrderResponseDTO order;

	@Override
	public StatementResponseDTO fromJsonString(String jsonString) {
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

	public String getCancelTransactionId() {
		return cancelTransactionId;
	}

	public void setCancelTransactionId(String cancelTransactionId) {
		this.cancelTransactionId = cancelTransactionId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(String expireAt) {
		this.expireAt = expireAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderResponseDTO getOrder() {
		return order;
	}

	public void setOrder(OrderResponseDTO order) {
		this.order = order;
	}
}
