package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class CmsPageContentSlotsResponseDTO extends AbstractDTO<CmsPageContentSlotsResponseDTO> {
    private List<ContentSlotResponseDTO> contentSlot;

    public List<ContentSlotResponseDTO> getContentSlot() {
        return contentSlot;
    }

    public void setContentSlot(List<ContentSlotResponseDTO> contentSlot) {
        this.contentSlot = contentSlot;
    }
}
