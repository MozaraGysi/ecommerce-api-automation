package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class ProductCategorySearchPageResponseDTO extends AbstractDTO<ProductCategorySearchPageResponseDTO> {
    private List<ProductResponseDTO> products;

    public List<ProductResponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDTO> products) {
        this.products = products;
    }
}
