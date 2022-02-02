package OCC.DTOs;

import java.util.List;

public class CmsComponentsResponseDTO {
    public List<ComponentResponseDTO> component;

    public List<ComponentResponseDTO> getComponent() {
        return component;
    }

    public void setComponent(List<ComponentResponseDTO> component) {
        this.component = component;

    }
}
