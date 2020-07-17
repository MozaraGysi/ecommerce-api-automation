package SuperApp.Tests;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class Cart {

    @Test
    public void RegistrationSuccessful() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        final JsonObject requestParams = new JsonObject();

        requestParams.addProperty("userName", "TOOdaeeressadasLSQA-Test");
        requestParams.addProperty("password", "Tesdasdasdasst@@123");
        request.contentType("application/json");

        request.body(requestParams.toString());
        Response response = request.post("/Account/v1/SuperApp.Tests.User");

        Assert.assertEquals(response.getStatusCode(), 201);

        //String userID = response.getBody().jsonPath().getString("userID");
    }

}
