package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class AppComponentResponseDTO extends AbstractDTO<AppComponentResponseDTO> {
    public String id;
    public List<AppComponentBannerResponseDTO> banners;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AppComponentBannerResponseDTO> getBanners() {
        return banners;
    }

    public void setBanners(List<AppComponentBannerResponseDTO> banners) {
        this.banners = banners;
    }
}
