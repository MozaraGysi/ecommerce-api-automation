package OCC.Fixtures;

import OCC.DTOs.CartDTO;

public class CartDTOFixture {

	private CartDTO cartDTO;

	public CartDTOFixture() {
		cartDTO = new CartDTO();
		cartDTO.setProduct(new ProductDTOFixture().build());
		cartDTO.setQuantity(1L);

	}

	public CartDTO build() {
		return cartDTO;
	}

	public CartDTOFixture withExternalSellerProduct() {
		cartDTO = new CartDTO();
		cartDTO.setProduct(new ProductDTOFixture().withExternalSeller().build());
		cartDTO.setQuantity(1L);
		return this;
	}
}
