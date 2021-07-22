package OCC.Fixtures;

import OCC.DTOs.CartDTO;

public class CartDTOFixture {

	private CartDTO cartDTO;

	public CartDTOFixture() {
		cartDTO = new CartDTO();
	}

	public CartDTO build() {
		return cartDTO;
	}

	public CartDTOFixture withDefaultProduct() {
		cartDTO.setProduct(new ProductDTOFixture().withDefaultSeller().build());
		cartDTO.setQuantity(1L);
		return this;
	}

	public CartDTOFixture withExternalSellerProduct() {
		cartDTO.setProduct(new ProductDTOFixture().withExternalSeller().build());
		cartDTO.setQuantity(1L);
		return this;
	}
}
