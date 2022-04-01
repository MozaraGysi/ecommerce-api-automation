package OCC.DTOs.Response;

public class ContentSlotResponseDTO {
    private ComponentResponseDTO components;
    public String position;

    public ComponentResponseDTO getComponents() {
        return components;
    }

    public void setComponents(ComponentResponseDTO components) {
        this.components = components;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
