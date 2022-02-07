package Wallet.DTOs.Request;

import Wallet.DTOs.AbstractWalletDTO;
import Wallet.DTOs.OrderDTO;
import Wallet.Enums.CreditPointsTypeEnum;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class CreditPointsRequestDTO extends AbstractWalletDTO<CreditPointsRequestDTO> {

	private String document;
	private float amount;
	private String type;
	private String status;
	private String dateTime;
	private OrderDTO order;
	private Map<String, Object> extra;

	@Override
	public CreditPointsRequestDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
	}

	public float getCreditAmount() {
		if (CreditPointsTypeEnum.VALOR_MONETARIO.getValue().equals(this.type)) {
			return new BigDecimal(this.amount * 0.12f).setScale(2, RoundingMode.HALF_EVEN).floatValue();
		}
		return this.amount;
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
}
