package SuperApp.Tests;

import SuperApp.Utils;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class Authorization {
    Utils utils = new Utils();
    
    @Test
    public void Token()
    {
        String token = utils.GetToken();
    }
}