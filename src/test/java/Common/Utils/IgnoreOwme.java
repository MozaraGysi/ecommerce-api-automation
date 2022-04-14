package Common.Utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE,METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Test
@DisabledIfSystemProperty(named = "brand", matches = "Owme")

public @interface IgnoreOwme {

}
