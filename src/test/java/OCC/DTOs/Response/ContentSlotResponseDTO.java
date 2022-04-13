package OCC.DTOs.Response;

public class ContentSlotResponseDTO {
    private CmsComponentsResponseDTO components;
    public String position;

    public CmsComponentsResponseDTO getComponents() {
        return components;
    }

    public void setComponents(CmsComponentsResponseDTO components) {
        this.components = components;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
