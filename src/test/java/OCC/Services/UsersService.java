package OCC.Services;

import OCC.Fixtures.AddressRequestDTOFixture;
import OCC.Fixtures.UserRequestDTOFixture;
import OCC.Fixtures.UserRegisterRequestDTOFixture;
import OCC.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class UsersService {

    public static void Users() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.body(UserRegisterRequestDTOFixture.get().automationUser().addEmail().build().toJson().toString());
        Response response = request.post("/users?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void POST_Addresses() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.body(AddressRequestDTOFixture.get().addressRS().build().toJson().toString());
        Response response = request.post("/users/current/addresses?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void GET_Addresses() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/users/current/addresses?fields=FULL");
        Utils.setID_ADDRESS(response.getBody().jsonPath().get("addresses.id"));
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void PATCH_User() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());
        request.param("fields","FULL");
        request.body(UserRequestDTOFixture.get().addBirthday().addMobilePhone().addCpf().build().toJson().toString());
        Response response = request.patch("/users/current/?fields=FULL");
        response.print();
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

}
