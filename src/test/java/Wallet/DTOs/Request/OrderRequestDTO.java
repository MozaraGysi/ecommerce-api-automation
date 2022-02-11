package Wallet.DTOs.Request;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Map;

public class OrderRequestDTO extends AbstractDTO<OrderRequestDTO> {

	private String id;
	private float totalPrice;
	private ArrayList<ItemRequestDTO> items;
	private ArrayList<PaymentRequestDTO> payments;
	private AddressRequestDTO address;
	private Map<String, Object> extra;

	@Override
	public OrderRequestDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ArrayList<ItemRequestDTO> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemRequestDTO> items) {
		this.items = items;
	}

	public ArrayList<PaymentRequestDTO> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<PaymentRequestDTO> payments) {
		this.payments = payments;
	}

	public AddressRequestDTO getAddress() {
		return address;
	}

	public void setAddress(AddressRequestDTO address) {
		this.address = address;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}
}
