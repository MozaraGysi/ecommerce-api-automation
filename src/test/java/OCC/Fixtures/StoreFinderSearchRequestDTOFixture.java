package OCC.Fixtures;

import OCC.Data.OCCDataTest;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

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

    private StoreFinderSearchRequestDTOFixture random() {
		return this
        .withQuery(RandomStringUtils.random(6, true, false))
		.withLatitude(RandomUtils.nextDouble())
        .withLongitude(RandomUtils.nextDouble());
	}

	public static StoreFinderSearchRequestDTOFixture getRandom() {
		return StoreFinderSearchRequestDTOFixture.get().random();
	}

    public StoreFinderSearchRequestDTOFixture defaultRequestByPostalCode() {
        storeFinderSearchRequestDTO.setQuery(OCCDataTest.getDefaultPostalCode());
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByWrongPostalCode() {
        storeFinderSearchRequestDTO.setQuery(OCCDataTest.getDefaultWrongPostalCode());
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByCoordinates() {
        storeFinderSearchRequestDTO.setLatitude(OCCDataTest.getDefaultLatitude());
        storeFinderSearchRequestDTO.setLongitude(OCCDataTest.getDefaultLongitude());
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByAddress() {
        storeFinderSearchRequestDTO.setQuery(OCCDataTest.getDefaultAddress());
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestWrongAddress() {
        storeFinderSearchRequestDTO.setQuery(OCCDataTest.getDefaultWrongAddress());
        return this;
    }

    public StoreFinderSearchRequestDTOFixture withQuery(String query){
        storeFinderSearchRequestDTO.setQuery(query);
        return this;
    }

    public StoreFinderSearchRequestDTOFixture withLatitude(Double latitude){
        storeFinderSearchRequestDTO.setLatitude(latitude);
        return this;
    }

    public StoreFinderSearchRequestDTOFixture withLongitude(Double longitude){
        storeFinderSearchRequestDTO.setLongitude(longitude);
        return this;
    }

}
