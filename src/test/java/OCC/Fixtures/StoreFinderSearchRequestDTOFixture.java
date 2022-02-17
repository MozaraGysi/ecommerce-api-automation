package OCC.Fixtures;

import OCC.DTOs.StoreFinderSearchRequestDTO;

public class StoreFinderSearchRequestDTOFixture {

    private StoreFinderSearchRequestDTO storeFinderSearchRequestDTO;

    public StoreFinderSearchRequestDTOFixture() {
        storeFinderSearchRequestDTO = new StoreFinderSearchRequestDTO();
    }

    public StoreFinderSearchRequestDTO build() {
        return storeFinderSearchRequestDTO;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByPostalCode() {
        storeFinderSearchRequestDTO.setQuery("59073380");
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByWrongPostalCode() {
        storeFinderSearchRequestDTO.setQuery("590733800");
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByCoordinates() {
        storeFinderSearchRequestDTO.setLatitude(-5.7939646);
        storeFinderSearchRequestDTO.setLongitude(-35.1989197);
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByAddress() {
        storeFinderSearchRequestDTO.setQuery("Natal");
        return this;
    }
}
