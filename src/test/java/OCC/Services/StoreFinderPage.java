package OCC.Services;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.StoreFinderSearchRequestDTO;
import OCC.Fixtures.StoreFinderSearchRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.StoreFinderValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class StoreFinderPage {

    public static void GET_searchPostalcode() {

        StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = new StoreFinderSearchRequestDTOFixture().defaultRequestByPostalCode().build();

        Response response = APIClient.GET_stores(storeFinderSearchRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_searchCoordinates() {

        StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = new StoreFinderSearchRequestDTOFixture().defaultRequestByCoordinates().build();

        Response response = APIClient.GET_stores(storeFinderSearchRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_searchAddress() {

        StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = new StoreFinderSearchRequestDTOFixture().defaultRequestByAddress().build();

        Response response = APIClient.GET_stores(storeFinderSearchRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void GET_searchWrongPostalCode() {

        StoreFinderSearchRequestDTO storeFinderSearchRequestDTO = new StoreFinderSearchRequestDTOFixture().defaultRequestByWrongPostalCode().build();

        Response response = APIClient.GET_stores(storeFinderSearchRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new StoreFinderValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

}
