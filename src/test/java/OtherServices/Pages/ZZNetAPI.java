package OtherServices.Pages;

import OtherServices.APIHandler.ZZNetAPIValidation;
import OtherServices.Utils.Utils;
import io.restassured.RestAssured;
import org.apache.commons.codec.binary.Base64;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;


import static OtherServices.Utils.Utils.generateRandomString;
import static OtherServices.Utils.Utils.getBaseUrl;

public class ZZNetAPI {

    private static String generatedEmail;
    private static String Jsession;
    private static String LBWEB;

    public static void LoginTeleSalesAndSwitchToCustomer()
    {
        RestAssured.baseURI = getBaseUrl();

        RequestSpecification request = RestAssured.given();
        byte[] encodedBytes = Base64.encodeBase64(("testecwiarezzotelevendas@arezzo.com.br|teste1234|"+generatedEmail+"|"+Utils.getSite_UID()).getBytes());
        String data = new String(encodedBytes);
        request.auth().preemptive().basic("descomplica", "descomplica");
        request.basePath("?requestData="+data);
        Response response = request.get("zznet/client/telesales/login");
        Assertions.assertEquals(200, response.getStatusCode());
        ZZNetAPIValidation.ValidateResponseLoginAndCustomerSwitch(response.getBody().prettyPrint());
    }
    public static void CreateCustomer(String token)
    {
        RestAssured.baseURI = getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer" + token);
        request.contentType("multipart/form-data");
        generatedEmail = generateRandomString() + "@gmail.com";
        request.multiPart("login", generatedEmail);
        request.multiPart("firstName", "Teste");
        request.multiPart("lastName", "CWI");
        request.multiPart("birthday", "22/09/1980");
        request.multiPart("cpf", "580.931.980-75");
        request.multiPart("appUser", "false");
        request.multiPart("newsletter", "true");
        request.multiPart("landlinePhone", "5135627304");
        request.multiPart("mobilePhone", "51992639471");
        request.multiPart("defaultShippingAddress.addressName", "Thomas Rodrigues");
        request.multiPart("defaultShippingAddress.streetname", "Rua Mattes");
        request.multiPart("defaultShippingAddress.streetNumber", "77");
        request.multiPart("defaultShippingAddress.complement", "Fundos");
        request.multiPart("defaultShippingAddress.remarks", "Próximo ao Sesi");
        request.multiPart("defaultShippingAddress.postalCode", "01310-100");
        request.multiPart("defaultShippingAddress.district", "Centro");
        request.multiPart("defaultShippingAddress.town", "São Paulo");
        request.multiPart("defaultShippingAddress.region.isocode", "SP");
        request.multiPart("defaultShippingAddress.phone", "51992639471");

        Response response = request.post("arezzocows/" + Utils.getSite_UID() + "/customers/create");
        Assertions.assertEquals(200, response.getStatusCode());
        ZZNetAPIValidation.ValidateResponseCustomerCreate(response.getBody().prettyPrint());
    }
    public static String CSFRToken()
    {
        RestAssured.baseURI = getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.auth().preemptive().basic("descomplica", "descomplica");

        Response response = request.get("cart/refreshCSRFToken");
        Jsession = response.getCookie("JSESSIONID");
        LBWEB = response.getCookie("LBWEB");
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();

        return body.prettyPrint().replaceAll("\"", "");
    }
    public static void RegisterCart(String token)
    {
        RestAssured.baseURI = getBaseUrl();

        String json = "{ \"productEans\" : [\"7909276002141\"], \"productQuantities\" : [2], \"voucherCode\": \"\"}";
        RequestSpecification request = RestAssured.given();
        request.auth().preemptive().basic("descomplica", "descomplica");
        request.header("CSRFToken", token);
        request.cookie("JSESSIONID", Jsession);
        request.cookie("LBWEB", LBWEB);
        request.header("Content-Type", "application/json");
        request.body(json);

        Response response = request.post("cart/register-cart");
        Assertions.assertEquals(200, response.getStatusCode());
        ZZNetAPIValidation.ValidateRegisterCart(response.getBody().prettyPrint());
    }
    public static void CreateEmployee(String token)
    {
        RestAssured.baseURI = getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer" + token);
        request.contentType("multipart/form-data");
        request.multiPart("employeeCpf", "75557860010");
        request.multiPart("employeeLogin", "#arzbr_teste_automacao@loja.com");
        request.multiPart("employeeName", "Teste automacao");
        request.multiPart("employeePwd", "arezzo123");
        request.multiPart("abacosLogin", "61098_66473983171_FRQArezzo_SZ-BTL_thomasrodrigues_1");
        request.multiPart("employeeAddressData.streetname", "Rua Armando Mattes");
        request.multiPart("employeeAddressData.streetNumber", "77");
        request.multiPart("employeeAddressData.postalCode", "93180000");
        request.multiPart("employeeAddressData.district", "Centro");
        request.multiPart("employeeAddressData.town", "Portao");
        request.multiPart("employeeAddressData.region.isocode", "RS");

        Response response = request.post("arezzocows/arezzo/employee/create");
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
