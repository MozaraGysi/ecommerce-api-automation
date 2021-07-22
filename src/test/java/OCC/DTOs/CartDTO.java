package OCC.DTOs;

public class CartDTO extends AbstractDTO<CartDTO> {

	private ProductDTO product;
	private Long quantity;

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
