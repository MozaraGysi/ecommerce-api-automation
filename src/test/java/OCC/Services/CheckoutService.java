package OCC.Services;

import Common.Validators.StatusCodeCreatedValidator;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.Fixtures.CreditCardRequestDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.APIClient;
import OCC.Utils.Utils;
import OCC.Validators.RecoverOptionEmailValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CheckoutService {

    public static void putAddressesDelivery() {

        //TODO: call fixure
        Response response = APIClient.putAddressesDelivery();
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }

    public static void getDeliveryModes() {
        //TODO: call fixure
        Response response = APIClient.getDeliveryModes();
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void getPaymentMethods() {
        //TODO: call fixure
        Response response = APIClient.getPaymentMethods();
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void putPaymentMethod() {
        //TODO: call fixure
        Response response = APIClient.putPaymentMethod("CreditCard");
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void putPaymentMethodBoleto() {
        //TODO: call fixure
        Response response = APIClient.putPaymentMethod("Boleto");
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void postOrderBoleto() {
        //TODO: call fixure
        Response response = APIClient.postOrderBoleto();
        List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void postOrder() {
        //TODO: call fixure
        Response response = APIClient.postOrder();
        List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }
}
