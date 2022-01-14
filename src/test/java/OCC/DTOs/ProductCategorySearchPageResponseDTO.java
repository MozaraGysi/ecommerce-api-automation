package OCC.DTOs;

import java.util.List;

public class ProductCategorySearchPageResponseDTO extends AbstractDTO<ProductCategorySearchPageResponseDTO>{
    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
