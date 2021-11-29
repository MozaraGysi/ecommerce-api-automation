package OCC.Handlers;

import org.junit.jupiter.api.Assertions;

public class AuthorizationValidation {
    public static void CustomerAuthValidation(String json)
    {
        Assertions.assertTrue(json.contains("access_token"));
        Assertions.assertTrue(json.contains("token_type"));
        Assertions.assertTrue(json.contains("refresh_token"));
        Assertions.assertTrue(json.contains("expires_in"));
        Assertions.assertTrue(json.contains("scope"));
    }

    public static void AnonymousAuthValdiation(String json)
    {
        Assertions.assertTrue(json.contains("access_token"));
        Assertions.assertTrue(json.contains("token_type"));
        Assertions.assertTrue(json.contains("expires_in"));
        Assertions.assertTrue(json.contains("scope"));
    }

    public static void RegisterCustomerAppleIDValidation(String json)
    {
        Assertions.assertTrue(json.contains("access_token"));
        Assertions.assertTrue(json.contains("token_type"));
        Assertions.assertTrue(json.contains("refresh_token"));
        Assertions.assertTrue(json.contains("expires_in"));
        Assertions.assertTrue(json.contains("scope"));
    }

    public static void RegisterCustomerFacebookValidation(String json)
    {
        Assertions.assertTrue(json.contains("access_token"));
        Assertions.assertTrue(json.contains("token_type"));
        Assertions.assertTrue(json.contains("refresh_token"));
        Assertions.assertTrue(json.contains("expires_in"));
        Assertions.assertTrue(json.contains("scope"));
    }
}
