package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Request.RegionRequestDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class RegionValidator implements Validator {

    @Override
    public boolean validate(Response response) {
        RegionRequestDTO regionRequestDTO = new RegionRequestDTO().fromJsonString(response.getBody().asString());
        Assertions.assertNotNull(regionRequestDTO.getCountryIso());
        Assertions.assertNotNull(regionRequestDTO.getIsocode());
        Assertions.assertNotNull(regionRequestDTO.getIsocodeShort());
        Assertions.assertNotNull(regionRequestDTO.getName());

        return true;
    }
}
