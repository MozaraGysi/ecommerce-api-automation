package OCC.DTOs.Request;

import Common.AbstractDTO;

public class ImageRequestDTO extends AbstractDTO<ImageRequestDTO> {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
