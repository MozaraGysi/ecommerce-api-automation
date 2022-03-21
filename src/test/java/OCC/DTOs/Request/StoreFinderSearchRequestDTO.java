package OCC.DTOs.Request;

import Common.AbstractDTO;

public class StoreFinderSearchRequestDTO extends AbstractDTO<StoreFinderSearchRequestDTO> {

    private String query;
    private Double latitude;
    private Double longitude;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getlongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


}
