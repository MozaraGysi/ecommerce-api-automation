package OCC.Pages;

import OCC.Utils.Utils;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class UsersPage {

    public static void Users() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.body(getBodyJsonRegister().toString());
        Response response = request.post("/arezzocoocc/v2/"+Utils.getSite_UID()+"/users?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void POST_Addresses() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.body(getBodyJsonAddress_RS().toString());
        Response response = request.post("/arezzocoocc/v2/"+Utils.getSite_UID()+"/users/current/addresses?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void GET_Addresses() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/arezzocoocc/v2/"+Utils.getSite_UID()+"/users/current/addresses?fields=FULL");
        Utils.setID_ADDRESS(response.getBody().jsonPath().get("addresses.id"));
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void PATCH_User() {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.param("fields","FULL");
        request.body(getBodyJsonUser().toString());
        Response response = request.patch("/arezzocoocc/v2/"+Utils.getSite_UID()+"/users/current/?fields=FULL");
        response.print();
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static JsonObject getBodyJsonRegister() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("firstName", "Douglas");
        jsonObject.addProperty("lastName", "Golke");
        jsonObject.addProperty("password", "zero123@");
        jsonObject.addProperty("uid", Utils.email());
        jsonObject.addProperty("genderCode", "MALE");
        return jsonObject;
    }

    public static JsonObject getBodyJsonUser(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("birthday", "01/06/1985");
        jsonObject.addProperty("mobilePhone", "(51) 99743-5572");
//        jsonObject.addProperty("cpf", "038.346.910-46");
        jsonObject.addProperty("cpf", Utils.cpf());
//        jsonObject.addProperty("shoeSize", "36");
        return jsonObject;
    }

    public static JsonObject getBodyJsonAddress_RS(){
        JsonObject jsonObject = new JsonObject();
        JsonObject country = new JsonObject();
        JsonObject region = new JsonObject();
        country.addProperty("isocode","BR");
        region.addProperty("isocode", "BR-RS");
        region.addProperty("isocodeShort", "RS");
        region.addProperty("countryIso", "BR");
        region.addProperty("name", "São Leopoldo");
        jsonObject.addProperty("addressName", "Casa");
        jsonObject.addProperty("complement", "ap 414");
        jsonObject.add("country",country);
        jsonObject.addProperty("defaultAddress", false);
        jsonObject.addProperty("district", "Pinheiro");
        jsonObject.addProperty("firstName", "Douglas");
        jsonObject.addProperty("lastName", "Golke");
        jsonObject.addProperty("line1", "Avenida Imperatriz Leopoldina");
        jsonObject.addProperty("line2", "2500");
        jsonObject.addProperty("phone", "(51) 99743-5572");
        jsonObject.addProperty("postalCode", "93042-082");
        jsonObject.addProperty("town", "São Leopoldo");
        jsonObject.addProperty("titleCode", "sr");
        jsonObject.add("region",region);

        return jsonObject;
    }

    public static JsonObject getBodyJsonAddress_SP(){
        JsonObject jsonObject = new JsonObject();
        JsonObject country = new JsonObject();
        JsonObject region = new JsonObject();
        country.addProperty("isocode","BR");
        region.addProperty("isocode", "BR-SP");
        region.addProperty("isocodeShort", "SP");
        region.addProperty("countryIso", "BR");
        region.addProperty("name", "São Paulo");
        jsonObject.addProperty("addressName", "Casa");
        jsonObject.addProperty("complement", "ap 414");
        jsonObject.add("country",country);
        jsonObject.addProperty("defaultAddress", false);
        jsonObject.addProperty("district", "Avenida Paulista");
        jsonObject.addProperty("firstName", "Douglas");
        jsonObject.addProperty("lastName", "Golke");
        jsonObject.addProperty("line1", "Rua centro ");
        jsonObject.addProperty("line2", "2500");
        jsonObject.addProperty("phone", "(51) 99828-8513");
        jsonObject.addProperty("postalCode", "01311-100");
        jsonObject.addProperty("town", "São Paulo");
        jsonObject.addProperty("titleCode", "sr");
        jsonObject.add("region",region);

        return jsonObject;
    }

}
