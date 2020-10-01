package OCC.APIHandler;

import org.junit.Assert;

public class AuthorizationValidation {
    public static void CustomerAuthValidation(String json)
    {
        Assert.assertTrue(json.contains("access_token"));
        Assert.assertTrue(json.contains("token_type"));
        Assert.assertTrue(json.contains("refresh_token"));
        Assert.assertTrue(json.contains("expires_in"));
        Assert.assertTrue(json.contains("scope"));
    }

    public static void AnonymousAuthValdiation(String json)
    {
        Assert.assertTrue(json.contains("access_token"));
        Assert.assertTrue(json.contains("token_type"));
        Assert.assertTrue(json.contains("expires_in"));
        Assert.assertTrue(json.contains("scope"));
    }

    public static void RegisterCustomerAppleIDValidation(String json)
    {
        Assert.assertTrue(json.contains("access_token"));
        Assert.assertTrue(json.contains("token_type"));
        Assert.assertTrue(json.contains("refresh_token"));
        Assert.assertTrue(json.contains("expires_in"));
        Assert.assertTrue(json.contains("scope"));
    }

    public static void RegisterCustomerFacebookValidation(String json)
    {
        Assert.assertTrue(json.contains("access_token"));
        Assert.assertTrue(json.contains("token_type"));
        Assert.assertTrue(json.contains("refresh_token"));
        Assert.assertTrue(json.contains("expires_in"));
        Assert.assertTrue(json.contains("scope"));
    }
}
