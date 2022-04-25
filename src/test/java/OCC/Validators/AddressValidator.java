package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Request.AddressRequestDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class AddressValidator implements Validator {
    
    @Override
    public void validate(Response response) {

        AddressRequestDTO addressRequestDTO = new AddressRequestDTO().fromJsonString(response.getBody().asString());
        assertNotNull(addressRequestDTO.getAddressName());
        assertNotNull(addressRequestDTO.getComplement());
        assertNotNull(addressRequestDTO.getFirstName());
        assertNotNull(addressRequestDTO.getLastName());
        assertNotNull(addressRequestDTO.getDistrict());
        assertNotNull(addressRequestDTO.getCountry());
        assertNotNull(addressRequestDTO.getLine1());
        assertNotNull(addressRequestDTO.getLine2());
        assertNotNull(addressRequestDTO.getPostalCode());
        assertNotNull(addressRequestDTO.getPhone());
        assertNotNull(addressRequestDTO.getTitleCode());
        assertNotNull(addressRequestDTO.getTown());
        assertNotNull(addressRequestDTO.getRegion());

    }
}
