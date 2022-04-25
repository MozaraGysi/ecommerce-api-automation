package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.StoreFinderSearchResponseDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class StoreFinderWrongQueryValidator implements Validator {

	@Override
	public void validate(Response response) {
		StoreFinderSearchResponseDTO storesFinder = new StoreFinderSearchResponseDTO().fromJsonString(response.getBody().asString());

		assertEquals(0, storesFinder.getStores().size());

	}
}
