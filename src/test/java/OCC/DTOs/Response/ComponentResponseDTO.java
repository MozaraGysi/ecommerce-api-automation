package OCC.DTOs.Response;

import Common.AbstractDTO;

public class ComponentResponseDTO extends AbstractDTO<ComponentResponseDTO> {

    public String jsonContentBanners;
    public String url;
    public MediaResponseDTO media;

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
