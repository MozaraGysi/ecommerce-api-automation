package OCC.DTOs.Request;

import Common.AbstractDTO;
import OCC.DTOs.Response.ProductCategorySearchPageResponseDTO;

public class PriceRequestDTO extends AbstractDTO<ProductCategorySearchPageResponseDTO> {
    private Float value;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
