package OCC.Services;

import Common.Validators.StatusCodeCreatedValidator;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.CartRequestDTO;
import OCC.Fixtures.CartRequestDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.APIClient;
import OCC.Utils.Utils;
import OCC.Validators.CartValidator;
import OCC.Validators.CustomerAuthorizationValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class CartService {

    public static void postCart() {
        CartRequestDTO cartRequestDTO = CartRequestDTOFixture.get().withDefaultProduct().build();
        Response response = APIClient.postCart(cartRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CartValidator());
        validators.stream().forEach(validator -> validator.validate(response));

    }

    public static void postEntry() {

        CartRequestDTO cartRequestDTO = CartRequestDTOFixture.getRandom().build();
        Response response = APIClient.postEntry(cartRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CartValidator());
        validators.stream().forEach(validator -> validator.validate(response));

    }

    public static void postEntrySellerExterno() {

        CartRequestDTO cartRequestDTO = CartRequestDTOFixture.get().withExternalSellerProduct().build();
        Response response = APIClient.postEntrySellerExterno(cartRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CartValidator());
        validators.stream().forEach(validator -> validator.validate(response));

    }

    public static void getCart() {

        CartRequestDTO cartRequestDTO = CartRequestDTOFixture.getRandom().build();
        Response response = APIClient.getCart(cartRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CartValidator());
        validators.stream().forEach(validator -> validator.validate(response));

    }
}
