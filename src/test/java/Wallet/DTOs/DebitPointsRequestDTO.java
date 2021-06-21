package Wallet.DTOs;

import Wallet.Enums.DebitPointsTypeEnum;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class DebitPointsRequestDTO {

	private String document;
	private float amount;
	private String type;
	private String status;
	private String dateTime;
	private OrderDTO order;
	private Map<String, Object> extra;

	public static DebitPointsRequestDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, DebitPointsRequestDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public float getDebitAmount() {
		if (DebitPointsTypeEnum.VALOR_MONETARIO.getValue().equals(this.type)) {
			return new BigDecimal(this.amount * 0.12f).setScale(2, RoundingMode.HALF_EVEN).floatValue();
		}
		// TODO: Ajustar para this.amount, após o ajuste na API
		return new BigDecimal("0.0" + new BigDecimal(this.amount).setScale(0, RoundingMode.DOWN)).floatValue();
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
