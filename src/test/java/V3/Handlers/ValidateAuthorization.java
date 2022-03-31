package V3.Handlers;

import org.junit.jupiter.api.Assertions;

public class ValidateAuthorization {
    public static void CustomerAuthorizationValidation(String json)
    {
        Assertions.assertTrue(json.contains("access_token"));
        Assertions.assertTrue(json.contains("token_type"));
        Assertions.assertTrue(json.contains("refresh_token"));
        Assertions.assertTrue(json.contains("expires_in"));
    }
}
