package OCC.Fixtures;

import OCC.DTOs.Request.CmsPageContentRequestDTO;

public final class CmsPageRequestDTOFixture {

    private CmsPageContentRequestDTO cmsPageContentRequestDTO;

    private CmsPageRequestDTOFixture(){
        cmsPageContentRequestDTO = new CmsPageContentRequestDTO();
    }

    public static CmsPageRequestDTOFixture get() {
		return new CmsPageRequestDTOFixture();
	}

    public CmsPageContentRequestDTO build(){
        return cmsPageContentRequestDTO;
    }

    public CmsPageRequestDTOFixture defaultRequestByHome(){
        cmsPageContentRequestDTO.setFields("DEFAULT");
        return this;
    }
}
