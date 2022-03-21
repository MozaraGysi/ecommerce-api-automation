package OCC.DTOs.Response;

import Common.AbstractDTO;

public class CartResponseDTO extends AbstractDTO<CartResponseDTO> {

	private ProductResponseDTO product;
	private Long quantity;

	public ProductResponseDTO getProduct() {
		return product;
	}

	public void setProduct(ProductResponseDTO product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
