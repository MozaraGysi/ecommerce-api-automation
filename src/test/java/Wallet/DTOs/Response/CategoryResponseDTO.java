package Wallet.DTOs.Response;

import Wallet.DTOs.AbstractWalletDTO;
import com.google.gson.JsonObject;

public class CategoryResponseDTO extends AbstractWalletDTO<CategoryResponseDTO> {

	private String id;
	private String name;
	private String parentId;

	@Override
	public CategoryResponseDTO fromJsonString(String jsonString) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
