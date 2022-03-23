package OCC.Services;

import Common.Validators.StatusCodeCreatedValidator;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.CreditCardRequestDTO;
import OCC.Fixtures.CreditCardRequestDTOFixture;
import OCC.Utils.APIClient;
import OCC.Validators.CreditCardValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CheckoutService {

    private static String BOLETO = "Boleto";
    private static String CREDIT_CARD = "CreditCard";

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
        Response response = APIClient.putPaymentMethod(CREDIT_CARD);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void putPaymentMethodBoleto() {
        //TODO: call fixure
        Response response = APIClient.putPaymentMethod(BOLETO);
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

        CreditCardRequestDTO creditCardRequestDTO = CreditCardRequestDTOFixture.get().defaultCreditCard().build();
        Response response = APIClient.postOrder(creditCardRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator(), new CreditCardValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

    }
}
