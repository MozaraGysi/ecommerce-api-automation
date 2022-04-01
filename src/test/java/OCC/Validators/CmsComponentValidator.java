package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.CmsComponentsResponseDTO;
import OCC.DTOs.Response.CmsPageResponseDTO;
import OCC.DTOs.Response.ComponentResponseDTO;
import OCC.DTOs.Response.ContentSlotResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class CmsComponentValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        CmsComponentsResponseDTO cmsComponentsResponseDTO = new CmsComponentsResponseDTO().fromJsonString(response.getBody().asString());
        cmsComponentsResponseDTO.getComponents().forEach(components -> {
            Assertions.assertTrue(components.getId()!=null);
        });


        return true;
    }
}
