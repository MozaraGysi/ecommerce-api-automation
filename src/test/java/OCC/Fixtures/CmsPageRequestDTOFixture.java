package OCC.Fixtures;

import OCC.DTOs.CmsPageContentRequestDTO;

public class CmsPageRequestDTOFixture {
    private CmsPageContentRequestDTO cmsPageContentRequestDTO;

    public CmsPageRequestDTOFixture(){
        cmsPageContentRequestDTO = new CmsPageContentRequestDTO();
    }

    public CmsPageContentRequestDTO build(){
        return cmsPageContentRequestDTO;
    }

    public CmsPageRequestDTOFixture defaultRequestByHome(){
        cmsPageContentRequestDTO.setFields("DEFAULT");
        return this;
    }
}
