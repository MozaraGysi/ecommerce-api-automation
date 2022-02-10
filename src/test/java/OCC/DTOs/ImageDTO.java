package OCC.DTOs;

import Common.AbstractDTO;

public class ImageDTO extends AbstractDTO<ImageDTO> {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
