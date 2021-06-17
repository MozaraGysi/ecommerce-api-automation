package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CategorieDTO {

	private String id;
	private String name;
	private String parentId;

	public static CategorieDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, CategorieDTO.class);
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
