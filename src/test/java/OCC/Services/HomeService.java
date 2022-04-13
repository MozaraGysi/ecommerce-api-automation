package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.CmsPageContentRequestDTO;
import OCC.Fixtures.CmsPageRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class HomeService {

    public static void getSearchHomePageComponents() {
        CmsPageContentRequestDTO cmsPageContentRequestDTO = CmsPageRequestDTOFixture.get().defaultRequestByHome().build();

        Response response = APIClient.getHomepage(cmsPageContentRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CmsComponentValidator(), new CmsBannerValidator(), new CmsVideoValidator(), new CmsTwoBannerValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void getHomePageApp() {
        CmsPageContentRequestDTO cmsPageContentRequestDTO = CmsPageRequestDTOFixture.get().defaultRequestByHome().build();

        Response response = APIClient.getHomepageApp(cmsPageContentRequestDTO);

        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new AppComponentValidator(), new AppBannerValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }
}
