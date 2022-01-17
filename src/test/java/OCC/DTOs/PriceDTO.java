package OCC.DTOs;

public class PriceDTO extends AbstractDTO<ProductCategorySearchPageResponseDTO>{
    private Float value;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
