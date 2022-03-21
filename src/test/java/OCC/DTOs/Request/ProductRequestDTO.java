package OCC.DTOs.Request;

import Common.AbstractDTO;

import java.util.List;

public class ProductRequestDTO extends AbstractDTO<ProductRequestDTO> {

	private String code;

	private List<ImageRequestDTO> images;

	private PriceRequestDTO price;

	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ImageRequestDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageRequestDTO> images) {
		this.images = images;
	}

	public PriceRequestDTO getPrice() {
		return price;
	}

	public void setPrice(PriceRequestDTO price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
