package OCC.Validators;

import Common.Validators.Validator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class UsersValidator implements Validator {

    @Override
    public boolean validate(Response response) {
        Assertions.assertEquals(201, response.getStatusCode());
        return true;
    }
}
