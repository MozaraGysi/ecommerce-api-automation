package OCC.Validators;

import Common.Validators.Validator;
import OCC.DTOs.Response.AppComponentsResponseDTO;
import OCC.DTOs.Response.CmsComponentsResponseDTO;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class AppBannerValidator implements Validator {
    @Override
    public void validate(@NotNull Response response) {

        AppComponentsResponseDTO appComponentsResponseDTO = new AppComponentsResponseDTO().fromJsonString(response.getBody().asString());

        appComponentsResponseDTO.getComponents().forEach(components -> {
            if(components.getBanners()!=null) {
                components.getBanners().forEach(image -> {
                    if(image.getImage()!=null){
                        Assertions.assertFalse(image.getImage().isEmpty());
                    }
                });
            }
        });
    }
}
