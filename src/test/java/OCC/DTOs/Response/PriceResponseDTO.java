package OCC.DTOs.Response;

import Common.AbstractDTO;

public class PriceResponseDTO extends AbstractDTO<ProductCategorySearchPageResponseDTO> {

    private Float value;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
