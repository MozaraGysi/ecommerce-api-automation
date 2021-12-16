package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

public class ExpirePointsResponseDTO {

	private List<ExpirePointsDTO> customers;

	public static ExpirePointsResponseDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, ExpirePointsResponseDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public List<ExpirePointsDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<ExpirePointsDTO> customers) {
		this.customers = customers;
	}
}
