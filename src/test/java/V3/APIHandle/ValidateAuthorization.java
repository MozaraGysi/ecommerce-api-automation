package V3.APIHandle;

import org.junit.Assert;

public class ValidateAuthorization {
    public static void CustomerAuthorizationValidation(String json)
    {
        Assert.assertTrue(json.contains("access_token"));
        Assert.assertTrue(json.contains("token_type"));
        Assert.assertTrue(json.contains("refresh_token"));
        Assert.assertTrue(json.contains("expires_in"));
    }
}
