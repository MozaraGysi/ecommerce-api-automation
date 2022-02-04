package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.CmsPageContentRequestDTO;
import OCC.Fixtures.CmsPageRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    public static void GET_searchHomePageComponents() {
        CmsPageContentRequestDTO cmsPageContentRequestDTO = new CmsPageRequestDTOFixture().defaultRequestByHome().build();

        Response response = APIClient.GET_homepage(cmsPageContentRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CmsComponentValidator(), new CmsBannerValidator(), new CmsVideoValidator(), new CmsTwoBannerValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }
}
