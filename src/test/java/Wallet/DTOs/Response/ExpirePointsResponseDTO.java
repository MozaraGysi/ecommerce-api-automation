package Wallet.DTOs.Response;

import Wallet.DTOs.AbstractWalletDTO;
import com.google.gson.JsonObject;

import java.util.List;

public class ExpirePointsResponseDTO extends AbstractWalletDTO<ExpirePointsResponseDTO> {

	private List<CustomerExpirePointsResponseDTO> customers;

	@Override
	public ExpirePointsResponseDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
	}

	public List<CustomerExpirePointsResponseDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerExpirePointsResponseDTO> customers) {
		this.customers = customers;
	}
}
