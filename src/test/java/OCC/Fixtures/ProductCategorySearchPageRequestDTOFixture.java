package OCC.Fixtures;

import OCC.DTOs.ProductCategorySearchPageRequestDTO;

public class ProductCategorySearchPageRequestDTOFixture {
    private ProductCategorySearchPageRequestDTO productCategorySearchPageRequestDTO;

    public ProductCategorySearchPageRequestDTOFixture() {
        productCategorySearchPageRequestDTO = new ProductCategorySearchPageRequestDTO();
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
