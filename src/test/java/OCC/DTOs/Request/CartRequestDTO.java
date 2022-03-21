package OCC.DTOs.Request;

import Common.AbstractDTO;

public class CartRequestDTO extends AbstractDTO<CartRequestDTO> {

	private ProductRequestDTO product;
	private Long quantity;

	public ProductRequestDTO getProduct() {
		return product;
	}

	public void setProduct(ProductRequestDTO product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
