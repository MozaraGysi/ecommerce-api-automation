package OCC.DTOs.Response;

import Common.AbstractDTO;

public class CmsPageResponseDTO extends AbstractDTO<CmsPageResponseDTO> {
    private CmsPageContentSlotsResponseDTO contentSlots;

    public CmsPageContentSlotsResponseDTO getContentSlots() {
        return contentSlots;
    }

    public void setContentSlots(CmsPageContentSlotsResponseDTO contentSlots) {
        this.contentSlots = contentSlots;
    }
}
