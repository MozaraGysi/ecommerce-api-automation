package OCC.Fixtures;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import OCC.DTOs.Request.ProductCategorySearchPageRequestDTO;

import static OCC.Data.OCCDataTest.*;

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
        .withFields(FIELDS)
        .withQuery(RandomStringUtils.random(13, false, true) + "U")
        .withCurrentPage(String.valueOf(RandomUtils.nextInt(0, 9)));
	}

	public static ProductCategorySearchPageRequestDTOFixture getRandom() {
		return ProductCategorySearchPageRequestDTOFixture.get().random();
	}

    public ProductCategorySearchPageRequestDTOFixture defaultRequestByCode() {
        productCategorySearchPageRequestDTO.setFields(FIELDS);
        productCategorySearchPageRequestDTO.setQuery(getProductPadrao());
        productCategorySearchPageRequestDTO.setCurrentPage(PAGE);
        return this;
    }

    public ProductCategorySearchPageRequestDTOFixture defaultRequestFull() {
        productCategorySearchPageRequestDTO.setFields(FIELDS);
        productCategorySearchPageRequestDTO.setCurrentPage(PAGE);
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
