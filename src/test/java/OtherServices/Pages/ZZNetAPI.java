package OtherServices.Pages;

import OtherServices.APIHandler.ZZNetAPIValidation;
import OtherServices.Utils.Utils;
import io.restassured.RestAssured;
import org.apache.commons.codec.binary.Base64;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static OtherServices.Utils.Utils.generateRandomString;
import static OtherServices.Utils.Utils.getBaseUrl;

public class ZZNetAPI {

    private static String generatedEmail;

    public static void LoginTeleSalesAndSwitchToCustomer()
    {
        RestAssured.baseURI = getBaseUrl();

        RequestSpecification request = RestAssured.given();
        byte[] encodedBytes = Base64.encodeBase64(("testecwiarezzotelevendas@arezzo.com.br|teste1234|"+generatedEmail+"|"+Utils.getSite_UID()).getBytes());
        String data = new String(encodedBytes);
        request.auth().preemptive().basic("descomplica", "descomplica");
        request.basePath("?requestData="+data);
        Response response = request.get("zznet/client/telesales/login");
        Assert.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();
        ZZNetAPIValidation.ValidateResponseLoginAndCustomerSwitch(body.prettyPrint());
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
        Assert.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();
        ZZNetAPIValidation.ValidateResponseCustomerCreate(body.prettyPrint());
    }
    public static String CSFRToken()
    {
        RestAssured.baseURI = getBaseUrl();

        RequestSpecification request = RestAssured.given();

        Response response = request.get("cart/refreshCSRFToken");
        Assert.assertEquals(200, response.getStatusCode());
        ResponseBody body = response.getBody();

        return body.prettyPrint();
    }
    public static void RegisterCart(String token)
    {
        RestAssured.baseURI = getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("client_id", "arezzoco_ws");
        request.formParam("client_secret", "arezzoco2014");
        request.formParam("grant_type", "client_credentials");
        request.formParam("site_uid", "arezzo");

        Response response = request.post("arezzocows/oauth/v3/token");
        Assert.assertEquals(200, response.getStatusCode());

        response.jsonPath().get("access_token");
    }
    public static void CreateEmployee(String token)
    {
        RestAssured.baseURI = getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer" + token);
        Response response = request.post("arezzo/employee/create");
        Assert.assertEquals(200, response.getStatusCode());
    }
}
