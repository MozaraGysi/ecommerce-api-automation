package Wallet.DTOs.Response;

import Wallet.DTOs.AbstractWalletDTO;
import Wallet.DTOs.ExpirePointsDTO;
import com.google.gson.JsonObject;

import java.util.List;

public class ExpirePointsResponseDTO extends AbstractWalletDTO<ExpirePointsResponseDTO> {

	private List<ExpirePointsDTO> customers;

	@Override
	public ExpirePointsResponseDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
	}

	public List<ExpirePointsDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<ExpirePointsDTO> customers) {
		this.customers = customers;
	}
}
