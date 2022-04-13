package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class AppComponentsResponseDTO extends AbstractDTO<AppComponentsResponseDTO>{
    public List<AppComponentResponseDTO> components;

    public List<AppComponentResponseDTO> getComponents() {
        return components;
    }

    public void setComponents(List<AppComponentResponseDTO> components) {
        this.components = components;

    }
}
