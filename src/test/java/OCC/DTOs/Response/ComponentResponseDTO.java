package OCC.DTOs.Response;

import Common.AbstractDTO;

import java.util.List;

public class ComponentResponseDTO extends AbstractDTO<ComponentResponseDTO> {

    public String id;
    public List<ImageResponseDTO> banners;
    public String jsonContentBanners;
    public String url;
    public MediaResponseDTO media;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ImageResponseDTO> getBanners() {
        return banners;
    }

    public void setBanners(List<ImageResponseDTO> banners) {
        this.banners = banners;
    }

    public String getJsonContentBanners() {
        return jsonContentBanners;
    }

    public void setJsonContentBanners(String jsonContentBanners) {
        this.jsonContentBanners = jsonContentBanners;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MediaResponseDTO getMedia() {
        return media;
    }

    public void setMedia(MediaResponseDTO media) {
        this.media = media;
    }
}
