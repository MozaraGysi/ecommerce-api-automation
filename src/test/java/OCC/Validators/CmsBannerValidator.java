package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.CmsComponentsResponseDTO;
import OCC.DTOs.Response.CmsPageResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class CmsBannerValidator implements Validator {
    @Override
    public boolean validate(@NotNull Response response) {

        CmsComponentsResponseDTO cmsComponentsResponseDTO = new CmsComponentsResponseDTO().fromJsonString(response.getBody().asString());

        cmsComponentsResponseDTO.getComponents().forEach(components -> {
            if(components.getBanners()!=null) {
                components.getBanners().forEach(image -> {
                    if(image.getImage()!=null){
                        Assertions.assertFalse(image.getImage().isEmpty());
                    }
                });
            }
        });

        return true;
    }
}
