package OCC.Fixtures;

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
