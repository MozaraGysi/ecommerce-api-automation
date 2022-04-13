package OCC.DTOs.Response;

import Common.AbstractDTO;

public class AppComponentBannerResponseDTO extends AbstractDTO<AppComponentBannerResponseDTO> {
    public String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
