package OCC.Fixtures;

import OCC.DTOs.ProductDTO;
import OCC.Utils.Utils;

public class ProductDTOFixture {

	private ProductDTO productDTO;

	public ProductDTOFixture() {
		productDTO = new ProductDTO();
	}

	public ProductDTO build() {
		return productDTO;
	}

	public ProductDTOFixture withDefaultSeller() {
		productDTO.setCode(Utils.getProduct("Padrao").get(0).concat("-36"));
		return this;
	}

	public ProductDTOFixture withExternalSeller() {
		productDTO.setCode(Utils.getProduct("SellerExterno").get(0).concat("-36"));
		return this;
	}
}
