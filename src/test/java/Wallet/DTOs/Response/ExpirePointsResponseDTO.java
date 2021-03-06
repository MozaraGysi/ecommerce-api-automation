package Wallet.DTOs.Response;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

import java.util.List;

public class ExpirePointsResponseDTO extends AbstractDTO<ExpirePointsResponseDTO> {

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
