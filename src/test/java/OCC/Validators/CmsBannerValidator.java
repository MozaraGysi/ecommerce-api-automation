package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.CmsPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class CmsBannerValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        CmsPageResponseDTO cmsPageResponseDTO = new CmsPageResponseDTO().fromJsonString(response.getBody().asString());

        cmsPageResponseDTO.getContentSlots().getContentSlot().forEach(contentSlot -> {
            if (contentSlot.getPosition().equals("SectionVideo")){
                contentSlot.getComponents().getComponent().forEach(component -> {
                    Assertions.assertNotNull(component.getUrl());
                });
            }
        });
        return true;
    }
}
