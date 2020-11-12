package OtherServices.APIHandler;

import org.junit.jupiter.api.Assertions;

public class ZZNetAPIValidation {
    public static void ValidateResponseLoginAndCustomerSwitch(String response)
    {
        Assertions.assertTrue(response.contains("homepage"));
    }
    public static void ValidateResponseCustomerCreate(String response)
    {
        Assertions.assertTrue(response.contains("\"Customer created successfully.\""));
    }
    public static void ValidateRegisterCart(String response)
    {
        Assertions.assertTrue(response.contains("Cart registered successfully."));
    }
}
