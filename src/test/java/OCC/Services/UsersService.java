package OCC.Services;

import OCC.Fixtures.AddressDTOFixture;
import OCC.Fixtures.UserDTOFixture;
import OCC.Fixtures.UserRegisterDTOFixture;
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
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        request.body(new UserRegisterDTOFixture().automationUser().addEmail().build().toJson().toString());
        Response response = request.post("/users?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void postAddresses() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        request.body(new AddressDTOFixture().addressRS().build().toJson().toString());
        Response response = request.post("/users/current/addresses?fields=FULL");
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(201, response.getStatusCode());
    }

    public static void getAddresses() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        Response response = request.get("/users/current/addresses?fields=FULL");
        Utils.setIdAddress(response.getBody().jsonPath().get("addresses.id"));
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public static void patchUser() {
        RestAssured.baseURI = Utils.getBaseUrl(false);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization","Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());
        request.param("fields","FULL");
        request.body(new UserDTOFixture().addBirthday().addMobilePhone().addCpf().build().toJson().toString());
        Response response = request.patch("/users/current/?fields=FULL");
        response.print();
        Utils.setCookies(response.getCookies());
        Assertions.assertEquals(200, response.getStatusCode());
    }

}
