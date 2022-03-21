package OCC.Fixtures;

import org.apache.commons.lang.RandomStringUtils;

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

    private CmsPageRequestDTOFixture random() {
		return this
		.withDefaultRequestByHome(RandomStringUtils.random(7, true, false));
	}

    public static CmsPageRequestDTOFixture getRandom() {
		return CmsPageRequestDTOFixture.get().random();
	}

    public CmsPageRequestDTOFixture defaultRequestByHome(){
        cmsPageContentRequestDTO.setFields("DEFAULT");
        return this;
    }

    public CmsPageRequestDTOFixture withDefaultRequestByHome(String field){
        cmsPageContentRequestDTO.setFields(field);
        return this;
    }


}
