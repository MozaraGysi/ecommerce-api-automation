package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class CmsComponentsResponseDTO extends AbstractDTO<CmsComponentsResponseDTO>{
    public List<ComponentResponseDTO> components;

    public List<ComponentResponseDTO> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentResponseDTO> components) {
        this.components = components;

    }
}
