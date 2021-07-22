package OCC.Fixtures;

import OCC.DTOs.ProductDTO;
import OCC.Utils.Utils;

public class ProductDTOFixture {

	private ProductDTO productDTO;

	public ProductDTOFixture() {
		productDTO = new ProductDTO();
		productDTO.setCode(Utils.getProduct("Padrao").get(0).concat("-36"));
	}

	public ProductDTO build() {
		return productDTO;
	}

	public ProductDTOFixture withExternalSeller() {
		productDTO = new ProductDTO();
		productDTO.setCode(Utils.getProduct("SellerExterno").get(0).concat("-36"));
		return this;
	}
}
