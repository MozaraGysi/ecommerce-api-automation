package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.StoreFinderSearchResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;



public class StoreFinderValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        StoreFinderSearchResponseDTO storeFinderSearchResponseDTO = new StoreFinderSearchResponseDTO().fromJsonString(response.getBody().asString());

        Assertions.assertTrue(storeFinderSearchResponseDTO.getStores().get(0).getOpeningHoursMessage().contains("MidWay Mall"));
        return true;
    }
}
