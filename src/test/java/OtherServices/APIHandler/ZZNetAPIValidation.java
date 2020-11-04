package OtherServices.APIHandler;

import org.junit.Assert;

public class ZZNetAPIValidation {
    public static void ValidateResponseLoginAndCustomerSwitch(String response)
    {
        Assert.assertTrue(response.contains("Homepage"));
    }
    public static void ValidateResponseCustomerCreate(String response)
    {
        Assert.assertTrue(response.contains("\"Customer created successfully.\""));
    }
}
