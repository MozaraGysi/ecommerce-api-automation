package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.AppComponentsResponseDTO;
import OCC.DTOs.Response.CmsComponentsResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class AppComponentValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        AppComponentsResponseDTO appComponentsResponseDTO = new AppComponentsResponseDTO().fromJsonString(response.getBody().asString());
        appComponentsResponseDTO.getComponents().forEach(components -> {
            Assertions.assertTrue(components.getId()!=null);
        });
        return true;
    }
}
