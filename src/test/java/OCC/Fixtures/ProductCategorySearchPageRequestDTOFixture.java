package OCC.Fixtures;

import OCC.DTOs.Request.ProductCategorySearchPageRequestDTO;

public final class ProductCategorySearchPageRequestDTOFixture {
    private ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO;

    private ProductCategorySearchPageRequestDTOFixture() {
        productCategorySearchPageRequestDTO = new ProductCategorySearchPageRequestDTO();
    }

    public static ProductCategorySearchPageRequestDTOFixture get(){
		return new ProductCategorySearchPageRequestDTOFixture();
	}

    public ProductCategorySearchPageRequestDTO build() {
        return productCategorySearchPageRequestDTO;
    }

    public ProductCategorySearchPageRequestDTOFixture defaultRequestByCode() {
        productCategorySearchPageRequestDTO.setFields("FULL");
        productCategorySearchPageRequestDTO.setQuery("3510500180001U");
        productCategorySearchPageRequestDTO.setCurrentPage("0");
        return this;
    }

    public ProductCategorySearchPageRequestDTOFixture defaultRequestFull() {
        productCategorySearchPageRequestDTO.setFields("FULL");
        productCategorySearchPageRequestDTO.setCurrentPage("0");
        return this;
    }

}
