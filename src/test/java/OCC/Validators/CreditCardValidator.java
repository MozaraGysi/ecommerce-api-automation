package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Request.CreditCardRequestDTO;
import OCC.DTOs.Response.CreditCardResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CreditCardValidator implements Validator {

    @Override
    public boolean validate(Response response) {

        CreditCardResponseDTO creditCardResponseDTO = new CreditCardResponseDTO().fromJsonString(response.getBody().asString());
        Assertions.assertNotNull(creditCardResponseDTO.getCardNumber());
        Assertions.assertNotNull(creditCardResponseDTO.getAccountHolderName());
        Assertions.assertNotNull(creditCardResponseDTO.getCpf());
        Assertions.assertNotNull(creditCardResponseDTO.getExpiryMonth());
        Assertions.assertNotNull(creditCardResponseDTO.getInstallments());
        Assertions.assertNotNull(creditCardResponseDTO.getExpiryYear());
        Assertions.assertNotNull(creditCardResponseDTO.getSecurityCode());

        return true;
    }
}
