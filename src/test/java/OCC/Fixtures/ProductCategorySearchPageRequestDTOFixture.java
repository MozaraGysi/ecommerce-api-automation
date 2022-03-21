package OCC.Fixtures;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

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

    private ProductCategorySearchPageRequestDTOFixture random() {
		return this
        .withFields("FULL")
        .withQuery(RandomStringUtils.random(13, false, true) + "U")
        .withCurrentPage(String.valueOf(RandomUtils.nextInt(0, 9)));
	}

	public static ProductCategorySearchPageRequestDTOFixture getRandom() {
		return ProductCategorySearchPageRequestDTOFixture.get().random();
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

    public ProductCategorySearchPageRequestDTOFixture withFields(String fields){
        productCategorySearchPageRequestDTO.setFields(fields);
        return this;
    }

    public ProductCategorySearchPageRequestDTOFixture withQuery(String query){
        productCategorySearchPageRequestDTO.setQuery(query);
        return this;
    }

    public ProductCategorySearchPageRequestDTOFixture withCurrentPage(String currentPage){
        productCategorySearchPageRequestDTO.setCurrentPage(currentPage);
        return this;
    }


}
