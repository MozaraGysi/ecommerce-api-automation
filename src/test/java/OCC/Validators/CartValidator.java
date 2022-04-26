package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.CartResponseDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CartValidator implements Validator {

    @Override
    public void validate(Response response) {

        CartResponseDTO cartResponseDTO = new CartResponseDTO().fromJsonString(response.getBody().asString());
        Assertions.assertNotNull(cartResponseDTO.getProduct());
        Assertions.assertNotNull(cartResponseDTO.getQuantity());

    }
}
