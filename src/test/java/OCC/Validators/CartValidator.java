package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.CartResponseDTO;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class CartValidator implements Validator {

    @Override
    public void validate(Response response) {

        CartResponseDTO cartResponseDTO = new CartResponseDTO().fromJsonString(response.getBody().asString());
        assertNotNull(cartResponseDTO.getProduct());
        assertNotNull(cartResponseDTO.getQuantity());

    }
}
