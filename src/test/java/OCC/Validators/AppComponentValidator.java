package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.AppComponentsResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import static org.junit.jupiter.api.Assertions.*;

public class AppComponentValidator implements Validator {
    @Override
    public void validate(@NotNull Response response) {

        AppComponentsResponseDTO appComponentsResponseDTO = new AppComponentsResponseDTO().fromJsonString(response.getBody().asString());
        appComponentsResponseDTO.getComponents().forEach(components -> {
            assertTrue(components.getId()!=null);
        });
    }
}
