package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.CreditCardResponseDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidator implements Validator {

    @Override
    public void validate(Response response) {

        CreditCardResponseDTO creditCardResponseDTO = new CreditCardResponseDTO().fromJsonString(response.getBody().asString());
        assertNotNull(creditCardResponseDTO.getCardNumber());
        assertNotNull(creditCardResponseDTO.getAccountHolderName());
        assertNotNull(creditCardResponseDTO.getCpf());
        assertNotNull(creditCardResponseDTO.getExpiryMonth());
        assertNotNull(creditCardResponseDTO.getInstallments());
        assertNotNull(creditCardResponseDTO.getExpiryYear());
        assertNotNull(creditCardResponseDTO.getSecurityCode());

    }
}
