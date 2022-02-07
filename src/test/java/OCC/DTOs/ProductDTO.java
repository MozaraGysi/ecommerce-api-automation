package OCC.DTOs;

import Common.AbstractDTO;

import java.util.List;

public class ProductDTO extends AbstractDTO<ProductDTO> {

	private String code;

	private List<ImageDTO> images;

	private PriceDTO price;

	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}

	public PriceDTO getPrice() {
		return price;
	}

	public void setPrice(PriceDTO price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
