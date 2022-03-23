package OCC.Services;

import Common.Validators.StatusCodeCreatedValidator;
import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.BoletoRequestDTO;
import OCC.DTOs.Request.CreditCardRequestDTO;
import OCC.DTOs.Request.DeliveryModeRequestDTO;
import OCC.DTOs.Request.PaymentModeRequestDTO;
import OCC.Fixtures.BoletoRequestDTOFixture;
import OCC.Fixtures.CreditCardRequestDTOFixture;
import OCC.Fixtures.DeliveryModesRequestDTOFixture;
import OCC.Fixtures.PaymentModeRequestDTOFixture;
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

        Response response = APIClient.putAddressesDelivery();
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void getDeliveryModes() {

        DeliveryModeRequestDTO deliveryModeRequestDTO = DeliveryModesRequestDTOFixture.get().build();
        Response response = APIClient.getDeliveryModes(deliveryModeRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void getPaymentMethods() {

        PaymentModeRequestDTO paymentModeRequestDTO = PaymentModeRequestDTOFixture.get().build();
        Response response = APIClient.getPaymentMethods(paymentModeRequestDTO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void putPaymentMethod() {

        Response response = APIClient.putPaymentMethod(CREDIT_CARD);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void putPaymentMethodBoleto() {

        Response response = APIClient.putPaymentMethod(BOLETO);
        List<Validator> validators = Arrays.asList(new StatusCodeOKValidator());
        Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
    }

    public static void postOrderBoleto() {

        BoletoRequestDTO boletoRequestDTO = BoletoRequestDTOFixture.get().build();
        Response response = APIClient.postOrderBoleto(boletoRequestDTO);
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
