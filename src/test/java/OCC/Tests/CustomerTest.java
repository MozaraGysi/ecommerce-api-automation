package OCC.Tests;

import OCC.Services.AuthorizationService;
import OCC.Services.CartService;
import OCC.Services.CheckoutService;
import OCC.Services.UsersService;
import OCC.Utils.Utils;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTest {

    @BeforeEach
    public void init() {
        Utils.init();
    }

    @Test
    @Order(1)
    public void register_NEWUser_BuyCreditCard() {
        AuthorizationService.AnonymousAuth();
        UsersService.Users();
        AuthorizationService.CustomerTokenNewUser();
        UsersService.POST_Addresses();
        UsersService.PATCH_User();
        CartService.POST_Cart();
        CartService.POST_Entry();
        CartService.GET_Cart();
        UsersService.GET_Addresses();
        CheckoutService.PUT_AddressesDelivery();
        CheckoutService.GET_DeliveryModes();
        CheckoutService.GET_PaymentMethods();
        CheckoutService.PUT_PaymentMethod();
        CheckoutService.POST_Order();
    }

    @Test
    @Order(2)
    public void register_NEWUser_BuyCreditCard_SellerExterno() {
        AuthorizationService.AnonymousAuth();
        UsersService.Users();
        AuthorizationService.CustomerTokenNewUser();
        UsersService.POST_Addresses();
        UsersService.PATCH_User();
        CartService.POST_Cart();
        CartService.POST_Entry_SellerExterno();
        CartService.GET_Cart();
        UsersService.GET_Addresses();
        CheckoutService.PUT_AddressesDelivery();
        CheckoutService.GET_DeliveryModes();
        CheckoutService.GET_PaymentMethods();
        CheckoutService.PUT_PaymentMethod();
        CheckoutService.POST_Order();
    }

    @Test
    @Order(3)
    public void register_NEWUser_BuyBoleto() {
        AuthorizationService.AnonymousAuth();
        UsersService.Users();
        AuthorizationService.CustomerTokenNewUser();
        UsersService.POST_Addresses();
        UsersService.PATCH_User();
        CartService.POST_Cart();
        CartService.POST_Entry();
        CartService.GET_Cart();
        UsersService.GET_Addresses();
        CheckoutService.PUT_AddressesDelivery();
        CheckoutService.GET_DeliveryModes();
        CheckoutService.GET_PaymentMethods();
        CheckoutService.PUT_PaymentMethodBoleto();
        CheckoutService.POST_OrderBoleto();
    }

    @Test
    @Order(4)
    public void register_OLDUser_BuyCreditCard() {
        AuthorizationService.CustomerToken();
        CartService.POST_Cart();
        CartService.POST_Entry();
        CartService.GET_Cart();
        UsersService.GET_Addresses();
        CheckoutService.PUT_AddressesDelivery();
        CheckoutService.GET_DeliveryModes();
        CheckoutService.GET_PaymentMethods();
        CheckoutService.PUT_PaymentMethod();
        CheckoutService.POST_Order();
    }

    @Test
    @Order(5)
    public void register_OLDUser_BuyCreditCard_SellerExterno() {
        AuthorizationService.CustomerToken();
        CartService.POST_Cart();
        CartService.POST_Entry_SellerExterno();
        CartService.GET_Cart();
        UsersService.GET_Addresses();
        CheckoutService.PUT_AddressesDelivery();
        CheckoutService.GET_DeliveryModes();
        CheckoutService.GET_PaymentMethods();
        CheckoutService.PUT_PaymentMethod();
        CheckoutService.POST_Order();
    }

    @Test
    @Order(6)
    public void register_OLDUser_BuyBoleto() {
        AuthorizationService.CustomerToken();
        CartService.POST_Cart();
        CartService.POST_Entry();
        CartService.GET_Cart();
        UsersService.GET_Addresses();
        CheckoutService.PUT_AddressesDelivery();
        CheckoutService.GET_DeliveryModes();
        CheckoutService.GET_PaymentMethods();
        CheckoutService.PUT_PaymentMethodBoleto();
        CheckoutService.POST_OrderBoleto();
    }

}
