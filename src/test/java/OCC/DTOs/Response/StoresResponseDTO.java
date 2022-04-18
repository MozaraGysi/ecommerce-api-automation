package OCC.DTOs.Response;

public class StoresResponseDTO {

    private String openingHoursMessage;
    private String displayName;
    private String formattedDistance;
    private String name;
    private AddressResponseDTO address;

    public String getOpeningHoursMessage() {
        return openingHoursMessage;
    }

    public void setOpeningHoursMessage(String openingHoursMessage) {
        this.openingHoursMessage = openingHoursMessage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFormattedDistance() {
        return formattedDistance;
    }

    public void setFormattedDistance(String formattedDistance) {
        this.formattedDistance = formattedDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressResponseDTO getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDTO address) {
        this.address = address;
    }
}
