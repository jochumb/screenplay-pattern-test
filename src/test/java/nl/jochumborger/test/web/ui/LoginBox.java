package nl.jochumborger.test.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by jochum on 08/07/16.
 */
public class LoginBox {
    public static Target USERNAME_FIELD = Target.the("username field").located(By.id("signin-email"));
    public static Target PASSWORD_FIELD = Target.the("password field").located(By.id("signin-password"));
    public static Target LOGIN_BUTTON = Target.the("password field").located(By.cssSelector("button.submit"));
}
