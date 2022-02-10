package Wallet.DTOs.Request;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Map;

public class ItemRequestDTO extends AbstractDTO<ItemRequestDTO> {

	private String id;
	private String sku;
	private String name;
	private float price;
	private String originalPrice;
	private float quantity;
	private String brand;
	private ArrayList<CategoryRequestDTO> categories = new ArrayList<>();
	private String imageUrl;
	private Map<String, Object> extra;

	@Override
	public ItemRequestDTO fromJsonString(String jsonString) {
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ArrayList<CategoryRequestDTO> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<CategoryRequestDTO> categories) {
		this.categories = categories;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}
}
