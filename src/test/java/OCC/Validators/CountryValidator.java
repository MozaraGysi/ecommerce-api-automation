package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Request.CountryRequestDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CountryValidator implements Validator {
    @Override
    public boolean validate(Response response) {
        CountryRequestDTO countryRequestDTO = new CountryRequestDTO().fromJsonString(response.getBody().asString());
        Assertions.assertNotNull(countryRequestDTO.getIsocode());

        return true;
    }
}
