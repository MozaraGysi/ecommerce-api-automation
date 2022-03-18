package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class ProductResponseDTO extends AbstractDTO<ProductResponseDTO> {

	private String code;

	private List<ImageResponseDTO> images;

	private PriceResponseDTO price;

	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ImageResponseDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageResponseDTO> images) {
		this.images = images;
	}

	public PriceResponseDTO getPrice() {
		return price;
	}

	public void setPrice(PriceResponseDTO price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
