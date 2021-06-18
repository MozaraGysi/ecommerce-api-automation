package Wallet.DTOs;

import Wallet.Fixtures.OrderDTOFixture;
import Wallet.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

public class DebitPointsDTO {

	private String document;
	private float amount;
	private String type;
	//esse campo não está no swagger mas ao chamar o endpoint ele pede
	private String status;
	private String dateTime;
	private OrderDTO order;
	private Map<String, Object> extra;

	public static DebitPointsDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, DebitPointsDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public static DebitPointsDTO build() {
		DebitPointsDTO dto = new DebitPointsDTO();
		dto.setDocument(Utils.getCPF());
		dto.setAmount(100);
		dto.setStatus("CONFIRMADO");
		dto.setType("VALOR_MONETARIO");
		dto.setDateTime("2004-02-12T14:18:20+00:00");
		dto.setOrder(OrderDTOFixture.build());
		return dto;
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
