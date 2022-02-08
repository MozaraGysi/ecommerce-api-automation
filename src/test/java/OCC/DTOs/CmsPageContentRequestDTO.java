package OCC.DTOs;

import Common.AbstractDTO;

public class CmsPageContentRequestDTO extends AbstractDTO<CmsPageContentRequestDTO> {
    private String fields;

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}
