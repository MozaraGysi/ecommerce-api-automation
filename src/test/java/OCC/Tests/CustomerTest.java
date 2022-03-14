package OCC.Tests;

import OCC.Services.AuthorizationPage;
import OCC.Services.CartPage;
import OCC.Services.CheckoutPage;
import OCC.Services.UsersPage;
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
        AuthorizationPage.AnonymousAuth();
        UsersPage.Users();
        AuthorizationPage.CustomerTokenNewUser();
        UsersPage.POST_Addresses();
        UsersPage.PATCH_User();
        CartPage.POST_Cart();
        CartPage.POST_Entry();
        CartPage.GET_Cart();
        UsersPage.GET_Addresses();
        CheckoutPage.PUT_AddressesDelivery();
        CheckoutPage.GET_DeliveryModes();
        CheckoutPage.GET_PaymentMethods();
        CheckoutPage.PUT_PaymentMethod();
        CheckoutPage.POST_Order();
    }

    @Test
    @Order(2)
    public void register_NEWUser_BuyCreditCard_SellerExterno() {
        AuthorizationPage.AnonymousAuth();
        UsersPage.Users();
        AuthorizationPage.CustomerTokenNewUser();
        UsersPage.POST_Addresses();
        UsersPage.PATCH_User();
        CartPage.POST_Cart();
        CartPage.POST_Entry_SellerExterno();
        CartPage.GET_Cart();
        UsersPage.GET_Addresses();
        CheckoutPage.PUT_AddressesDelivery();
        CheckoutPage.GET_DeliveryModes();
        CheckoutPage.GET_PaymentMethods();
        CheckoutPage.PUT_PaymentMethod();
        CheckoutPage.POST_Order();
    }

    @Test
    @Order(3)
    public void register_NEWUser_BuyBoleto() {
        AuthorizationPage.AnonymousAuth();
        UsersPage.Users();
        AuthorizationPage.CustomerTokenNewUser();
        UsersPage.POST_Addresses();
        UsersPage.PATCH_User();
        CartPage.POST_Cart();
        CartPage.POST_Entry();
        CartPage.GET_Cart();
        UsersPage.GET_Addresses();
        CheckoutPage.PUT_AddressesDelivery();
        CheckoutPage.GET_DeliveryModes();
        CheckoutPage.GET_PaymentMethods();
        CheckoutPage.PUT_PaymentMethodBoleto();
        CheckoutPage.POST_OrderBoleto();
    }

    @Test
    @Order(4)
    public void register_OLDUser_BuyCreditCard() {
        AuthorizationPage.CustomerToken();
        CartPage.POST_Cart();
        CartPage.POST_Entry();
        CartPage.GET_Cart();
        UsersPage.GET_Addresses();
        CheckoutPage.PUT_AddressesDelivery();
        CheckoutPage.GET_DeliveryModes();
        CheckoutPage.GET_PaymentMethods();
        CheckoutPage.PUT_PaymentMethod();
        CheckoutPage.POST_Order();
    }

    @Test
    @Order(5)
    public void register_OLDUser_BuyCreditCard_SellerExterno() {
        AuthorizationPage.CustomerToken();
        CartPage.POST_Cart();
        CartPage.POST_Entry_SellerExterno();
        CartPage.GET_Cart();
        UsersPage.GET_Addresses();
        CheckoutPage.PUT_AddressesDelivery();
        CheckoutPage.GET_DeliveryModes();
        CheckoutPage.GET_PaymentMethods();
        CheckoutPage.PUT_PaymentMethod();
        CheckoutPage.POST_Order();
    }

    @Test
    @Order(6)
    public void register_OLDUser_BuyBoleto() {
        AuthorizationPage.CustomerToken();
        CartPage.POST_Cart();
        CartPage.POST_Entry();
        CartPage.GET_Cart();
        UsersPage.GET_Addresses();
        CheckoutPage.PUT_AddressesDelivery();
        CheckoutPage.GET_DeliveryModes();
        CheckoutPage.GET_PaymentMethods();
        CheckoutPage.PUT_PaymentMethodBoleto();
        CheckoutPage.POST_OrderBoleto();
    }

}
