package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.StoreFinderSearchRequestDTO;
import OCC.Fixtures.StoreFinderSearchRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.StoreFinderValidator;
import OCC.Validators.StoreFinderWrongQueryValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class StoreFinderService {

	public static void getSearchPostalCode() {
		StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = StoreFinderSearchRequestDTOFixture.get().defaultRequestByPostalCode().build();

		Response response = APIClient.getStores(storeFinderSearchRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getSearchCoordinates() {
		StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = StoreFinderSearchRequestDTOFixture.get().defaultRequestByCoordinates().build();

		Response response = APIClient.getStores(storeFinderSearchRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getSearchAddress() {
		StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = StoreFinderSearchRequestDTOFixture.get().defaultRequestByAddress().build();

		Response response = APIClient.getStores(storeFinderSearchRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getSearchWrongPostalCode() {
		StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = StoreFinderSearchRequestDTOFixture.get().defaultRequestByWrongPostalCode().build();

		Response response = APIClient.getStores(storeFinderSearchRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderWrongQueryValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getSearchWrongAddress() {
		StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = StoreFinderSearchRequestDTOFixture.get().defaultRequestWrongAddress().build();

		Response response = APIClient.getStores(storeFinderSearchRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderWrongQueryValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

}
