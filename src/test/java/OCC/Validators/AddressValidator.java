package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Request.AddressRequestDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class AddressValidator implements Validator {
    
    @Override
    public void validate(Response response) {

        AddressRequestDTO addressRequestDTO = new AddressRequestDTO().fromJsonString(response.getBody().asString());
        Assertions.assertNotNull(addressRequestDTO.getAddressName());
        Assertions.assertNotNull(addressRequestDTO.getComplement());
        Assertions.assertNotNull(addressRequestDTO.getFirstName());
        Assertions.assertNotNull(addressRequestDTO.getLastName());
        Assertions.assertNotNull(addressRequestDTO.getDistrict());
        Assertions.assertNotNull(addressRequestDTO.getCountry());
        Assertions.assertNotNull(addressRequestDTO.getLine1());
        Assertions.assertNotNull(addressRequestDTO.getLine2());
        Assertions.assertNotNull(addressRequestDTO.getPostalCode());
        Assertions.assertNotNull(addressRequestDTO.getPhone());
        Assertions.assertNotNull(addressRequestDTO.getTitleCode());
        Assertions.assertNotNull(addressRequestDTO.getTown());
        Assertions.assertNotNull(addressRequestDTO.getRegion());

    }
}
