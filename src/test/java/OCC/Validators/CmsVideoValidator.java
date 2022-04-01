package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.CmsPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class CmsVideoValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        CmsPageResponseDTO cmsPageResponseDTO = new CmsPageResponseDTO().fromJsonString(response.getBody().asString());

        cmsPageResponseDTO.getContentSlots().getContentSlot().forEach(contentSlot -> {
            if (contentSlot.getPosition().equals("SectionBannerCarousel")){
                Assertions.assertFalse(contentSlot.getComponents().getMedia().getUrl().isEmpty());
            }
        });
        return true;
    }
}
