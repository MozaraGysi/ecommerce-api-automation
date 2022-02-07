package OCC.DTOs;

import Common.AbstractDTO;

public class ProductCategorySearchPageRequestDTO extends AbstractDTO<ProductCategorySearchPageRequestDTO> {

    private String fields;
    private String query;
    private String currentPage;

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }
}
