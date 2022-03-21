
package OCC.DTOs.Request;

import Common.AbstractDTO;


public class PriceRequestDTO extends AbstractDTO<ProductCategorySearchPageRequestDTO> {

    private Float value;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
