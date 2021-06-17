package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Map;

public class OrderDTO {

	private String id;
	private float totalPrice;
	private ArrayList<ItemDTO> items = new ArrayList<>();
	private ArrayList<PaymentDTO> payments = new ArrayList <> ();
	private AddressDTO address;
	private Map<String, Object> extra;

	public static OrderDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, OrderDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
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

	public ArrayList<ItemDTO> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemDTO> items) {
		this.items = items;
	}

	public ArrayList<PaymentDTO> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<PaymentDTO> payments) {
		this.payments = payments;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}
}
