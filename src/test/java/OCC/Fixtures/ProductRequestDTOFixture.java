package OCC.Fixtures;

import OCC.DTOs.Request.ProductRequestDTO;
import OCC.Utils.Utils;

public final class ProductRequestDTOFixture {

	private ProductRequestDTO productDTO;

	private ProductRequestDTOFixture() {
		productDTO = new ProductRequestDTO();
	}

	public static ProductRequestDTOFixture get(){
		return new ProductRequestDTOFixture();
	}

	public ProductRequestDTO build() {
		return productDTO;
	}

	public ProductRequestDTOFixture withDefaultSeller() {
		productDTO.setCode(Utils.getProduct("Padrao").get(0).concat("-36"));
		return this;
	}

	public ProductRequestDTOFixture withExternalSeller() {
		productDTO.setCode(Utils.getProduct("SellerExterno").get(0).concat("-36"));
		return this;
	}
}
