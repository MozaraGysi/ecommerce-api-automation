package OCC.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CartDTO {

	private ProductDTO product;
	private Long quantity;

	public static CartDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, CartDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
