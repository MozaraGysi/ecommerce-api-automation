package OCC.Fixtures;

import OCC.DTOs.Request.CartRequestDTO;

public final class CartRequestDTOFixture {

	private CartRequestDTO cartDTO;

	private CartRequestDTOFixture() {
		cartDTO = new CartRequestDTO();
	}

	public static CartRequestDTOFixture get() {
		return new CartRequestDTOFixture();
	}

	public CartRequestDTO build() {
		return cartDTO;
	}

	private CartRequestDTOFixture random() {
		return this
		.withDefaultProduct()
		.withExternalSellerProduct();
	}

	public static CartRequestDTOFixture getRandom() {
		return CartRequestDTOFixture.get().random();
	}

	public CartRequestDTOFixture withDefaultProduct() {
		cartDTO.setProduct(ProductRequestDTOFixture.get().withDefaultSeller().build());
		cartDTO.setQuantity(1L);
		return this;
	}

	public CartRequestDTOFixture withExternalSellerProduct() {
		cartDTO.setProduct(ProductRequestDTOFixture.get().withExternalSeller().build());
		cartDTO.setQuantity(1L);
		return this;
	}
}
