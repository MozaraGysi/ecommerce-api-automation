package OCC.Tests;

import OCC.Services.AuthorizationService;
import OCC.Services.CartService;
import OCC.Services.CheckoutService;
import OCC.Services.UsersService;
import OCC.Utils.Utils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTest {

    @BeforeEach
    public void init() {
        Utils.init();
    }

    @Test
    @Order(1)
    public void postRegisterNewUserBuyCreditCard() {
        AuthorizationService.AnonymousAuth();
        UsersService.Users();
        AuthorizationService.CustomerTokenNewUser();
        UsersService.postAddresses();
        UsersService.patchUser();
        CartService.postCart();
        CartService.postEntry();
        CartService.getCart();
        UsersService.getAddresses();
        CheckoutService.putAddressesDelivery();
        CheckoutService.getDeliveryModes();
        CheckoutService.getPaymentMethods();
        CheckoutService.putPaymentMethod();
        CheckoutService.postOrder();
    }

    @EnabledIfSystemProperty(named="brand",matches="Zzmall")
    @Test
    @Order(2)
    public void postRegisterNewUserBuyCreditCardSellerExterno() {
        AuthorizationService.AnonymousAuth();
        UsersService.Users();
        AuthorizationService.CustomerTokenNewUser();
        UsersService.postAddresses();
        UsersService.patchUser();
        CartService.postCart();
        CartService.postEntrySellerExterno();
        CartService.getCart();
        UsersService.getAddresses();
        CheckoutService.putAddressesDelivery();
        CheckoutService.getDeliveryModes();
        CheckoutService.getPaymentMethods();
        CheckoutService.putPaymentMethod();
        CheckoutService.postOrder();
    }

    @Test
    @Order(3)
    public void postRegisterNewUserBuyBoleto() {
        AuthorizationService.AnonymousAuth();
        UsersService.Users();
        AuthorizationService.CustomerTokenNewUser();
        UsersService.postAddresses();
        UsersService.patchUser();
        CartService.postCart();
        CartService.postEntry();
        CartService.getCart();
        UsersService.getAddresses();
        CheckoutService.putAddressesDelivery();
        CheckoutService.getDeliveryModes();
        CheckoutService.getPaymentMethods();
        CheckoutService.putPaymentMethodBoleto();
        CheckoutService.postOrderBoleto();
    }

    @Test
    @Order(4)
    public void postRegisterOldUserBuyCreditCard() {
        AuthorizationService.CustomerToken();
        CartService.postCart();
        CartService.postEntry();
        CartService.getCart();
        UsersService.getAddresses();
        CheckoutService.putAddressesDelivery();
        CheckoutService.getDeliveryModes();
        CheckoutService.getPaymentMethods();
        CheckoutService.putPaymentMethod();
        CheckoutService.postOrder();
    }

    @EnabledIfSystemProperty(named="brand",matches="Zzmall")
    @Test
    @Order(5)
    public void postRegisterOldUserBuyCreditCardSellerExterno() {
        AuthorizationService.CustomerToken();
        CartService.postCart();
        CartService.postEntrySellerExterno();
        CartService.getCart();
        UsersService.getAddresses();
        CheckoutService.putAddressesDelivery();
        CheckoutService.getDeliveryModes();
        CheckoutService.getPaymentMethods();
        CheckoutService.putPaymentMethod();
        CheckoutService.postOrder();
    }

    @Test
    @Order(6)
    public void postRegisterOldUserBuyBoleto() {
        AuthorizationService.CustomerToken();
        CartService.postCart();
        CartService.postEntry();
        CartService.getCart();
        UsersService.getAddresses();
        CheckoutService.putAddressesDelivery();
        CheckoutService.getDeliveryModes();
        CheckoutService.getPaymentMethods();
        CheckoutService.putPaymentMethodBoleto();
        CheckoutService.postOrderBoleto();
    }

}
