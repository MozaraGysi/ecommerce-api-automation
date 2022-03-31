package OtherServices.Pages;

import OtherServices.APIHandler.ZZNetAPIValidation;
import static OtherServices.Utils.Utils.*;

import OtherServices.Data.DataTest;
import io.restassured.RestAssured;
import org.apache.commons.codec.binary.Base64;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class ZZNetAPI {

    private static String generatedEmail;
    private static String jsession;
    private static String LBWEB;

    public static void LoginTeleSalesAndSwitchToCustomer() {
        RestAssured.baseURI = DataTest.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        byte[] encodedBytes = Base64.encodeBase64((DataTest.getLoginTele() + "|" + DataTest.getPasswordTele() + "|"+generatedEmail+"|"+getSite_UID()).getBytes());
        String data = new String(encodedBytes);
        request.auth().preemptive().basic(DataTest.getAuth(), DataTest.getAuth());
        request.basePath("?requestData="+data);
        Response response = request.get("zznet/client/telesales/login");
        Assertions.assertEquals(200, response.getStatusCode());
        ZZNetAPIValidation.ValidateResponseLoginAndCustomerSwitch(response.getBody().prettyPrint());
    }

    public static void CreateCustomer(String token) {
        RestAssured.baseURI = DataTest.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer" + token);
        request.contentType("multipart/form-data");
        generatedEmail = generateRandomString().toLowerCase() + "@gmail.com";
        request.multiPart("login", generatedEmail);
        request.multiPart("firstName", DataTest.getCustomerFirstName());
        request.multiPart("lastName", DataTest.getCustomerLastName());
        request.multiPart("birthday", DataTest.getCustomerBirthday());
        request.multiPart("cpf", DataTest.getCustomerCPF());
        request.multiPart("appUser", DataTest.getCustomerAppUser());
        request.multiPart("newsletter", DataTest.getCustomerNewsletter());
        request.multiPart("landlinePhone", DataTest.getCustomerLandlinePhone());
        request.multiPart("mobilePhone", DataTest.getCustomerMobilePhone());
        request.multiPart("defaultShippingAddress.addressName", DataTest.getCustomerAddressName());
        request.multiPart("defaultShippingAddress.streetname", DataTest.getCustomerStreetName());
        request.multiPart("defaultShippingAddress.streetNumber", DataTest.getCustomerStreetNumber());
        request.multiPart("defaultShippingAddress.complement", DataTest.getCustomerComplement());
        request.multiPart("defaultShippingAddress.remarks", DataTest.getCustomerRemarks());
        request.multiPart("defaultShippingAddress.postalCode", DataTest.getCustomerPostalCode());
        request.multiPart("defaultShippingAddress.district", DataTest.getCustomerDistrict());
        request.multiPart("defaultShippingAddress.town", DataTest.getCustomerTown());
        request.multiPart("defaultShippingAddress.region.isocode", DataTest.getCustomerRegion());
        request.multiPart("defaultShippingAddress.phone", DataTest.getCustomerMobilePhone());

        Response response = request.post("arezzocows/" + getSite_UID() + "/customers/create");
        Assertions.assertEquals(200, response.getStatusCode());
        ZZNetAPIValidation.ValidateResponseCustomerCreate(response.getBody().prettyPrint());
    }

    public static String CSFRToken() {
        RestAssured.baseURI = DataTest.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.auth().preemptive().basic(DataTest.getAuth(), DataTest.getAuth());

        Response response = request.get("cart/refreshCSRFToken");
        jsession = response.getCookie("JSESSIONID");
        LBWEB = response.getCookie("LBWEB");
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();

        return body.prettyPrint().replaceAll("\"", "");
    }

    public static void RegisterCart(String token) {
        RestAssured.baseURI = DataTest.getBaseUrl();

        String json = "{ \"productEans\" : [\"7909276002141\"], \"productQuantities\" : [2], \"voucherCode\": \"\"}";
        RequestSpecification request = RestAssured.given();
        request.auth().preemptive().basic(DataTest.getAuth(), DataTest.getAuth());
        request.header("CSRFToken", token);
        request.cookie("JSESSIONID", jsession);
        request.cookie("LBWEB", LBWEB);
        request.header("Content-Type", "application/json");
        request.body(json);

        Response response = request.post("cart/register-cart");
        Assertions.assertEquals(200, response.getStatusCode());
        ZZNetAPIValidation.ValidateRegisterCart(response.getBody().prettyPrint());
    }

    public static void CreateEmployee(String token) {
        RestAssured.baseURI = DataTest.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer" + token);
        request.contentType("multipart/form-data");
        request.multiPart("employeeCpf", DataTest.getEmployeeCpf());
        request.multiPart("employeeLogin", "#arzbr_" + generateRandomString().toLowerCase() + "@gmail.com");
        request.multiPart("employeeName", DataTest.getEmployeeName());
        request.multiPart("employeePwd", DataTest.getEmployeePwd());
        request.multiPart("birthday", DataTest.getEmployeeBirthday());
        request.multiPart("abacosLogin", DataTest.getAbacosLogin());
        request.multiPart("employeeAddressData.streetname", DataTest.getEmployeeStreetName());
        request.multiPart("employeeAddressData.streetNumber", DataTest.getEmployeeStreetNumber());
        request.multiPart("employeeAddressData.postalCode", DataTest.getEmployeePostalCode());
        request.multiPart("employeeAddressData.district", DataTest.getEmployeeDistrict());
        request.multiPart("employeeAddressData.town", DataTest.getEmployeeTown());
        request.multiPart("employeeAddressData.region.isocode", DataTest.getEmployeeRegion());

        Response response = request.post("arezzocows/"+ getSite_UID() + "/employee/create");
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
