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
        storeFinderSearchRequestDTO.setQuery("01310-100");
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByWrongPostalCode() {
        storeFinderSearchRequestDTO.setQuery("590733800");
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByCoordinates() {
        storeFinderSearchRequestDTO.setLatitude(-23.5628302);
        storeFinderSearchRequestDTO.setLongitude(-46.6546177);
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestByAddress() {
        storeFinderSearchRequestDTO.setQuery("São Paulo");
        return this;
    }

    public StoreFinderSearchRequestDTOFixture defaultRequestWrongAddress() {
        storeFinderSearchRequestDTO.setQuery("Endereço_errado");
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
