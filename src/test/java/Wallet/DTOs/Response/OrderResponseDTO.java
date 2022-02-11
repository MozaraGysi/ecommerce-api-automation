package Wallet.DTOs.Response;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Map;

public class OrderResponseDTO extends AbstractDTO<OrderResponseDTO> {

	private String id;
	private float totalPrice;
	private ArrayList<ItemResponseDTO> items;
	private ArrayList<PaymentResponseDTO> payments;
	private AddressResponseDTO address;
	private Map<String, Object> extra;

	@Override
	public OrderResponseDTO fromJsonString(String jsonString) {
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

	public ArrayList<ItemResponseDTO> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemResponseDTO> items) {
		this.items = items;
	}

	public ArrayList<PaymentResponseDTO> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<PaymentResponseDTO> payments) {
		this.payments = payments;
	}

	public AddressResponseDTO getAddress() {
		return address;
	}

	public void setAddress(AddressResponseDTO address) {
		this.address = address;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}
}
