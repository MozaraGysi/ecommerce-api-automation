package OCC.Fixtures;

import OCC.DTOs.Request.StoreFinderSearchRequestDTO;

public final class StoreFinderSearchRequestDTOFixture {

    private StoreFinderSearchRequestDTO storeFinderSearchRequestDTO;

    private StoreFinderSearchRequestDTOFixture() {
        storeFinderSearchRequestDTO = new StoreFinderSearchRequestDTO();
    }

    public static StoreFinderSearchRequestDTOFixture get(){
		return new StoreFinderSearchRequestDTOFixture();
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
