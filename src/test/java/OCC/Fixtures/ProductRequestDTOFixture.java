package OCC.Fixtures;

import OCC.DTOs.Request.ProductRequestDTO;
import OCC.Utils.Utils;

import static OCC.Data.OCCDataTest.*;

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

	private ProductRequestDTOFixture random() {
		return this
        .withDefaultSeller()
        .withExternalSeller();
	}

	public static ProductRequestDTOFixture getRandom() {
		return ProductRequestDTOFixture.get().random();
	}

	public ProductRequestDTOFixture withDefaultSeller() {
		productDTO.setCode(getProductPadrao());
		return this;
	}

	public ProductRequestDTOFixture withExternalSeller() {
		productDTO.setCode(getProductSellerExterno());
		return this;
	}
}
