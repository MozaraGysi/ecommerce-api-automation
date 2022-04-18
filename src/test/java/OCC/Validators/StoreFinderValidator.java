package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.StoreFinderSearchResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import static org.junit.jupiter.api.Assertions.*;


public class StoreFinderValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {
        StoreFinderSearchResponseDTO storesFinder = new StoreFinderSearchResponseDTO().fromJsonString(response.getBody().asString());

        assertNotNull(storesFinder.getStores());
        assertNotEquals(0, storesFinder.getStores().size());
        assertNotEquals(true, storesFinder.getStores().get(0).getDisplayName().isEmpty());
        assertNotEquals(true, storesFinder.getStores().get(0).getName().isEmpty());
        assertNotNull(storesFinder.getStores().get(0).getAddress());

        return true;
    }
}
