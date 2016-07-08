package nl.jochumborger.test.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by jochum on 08/07/16.
 */
public class UserMenu {
    public static Target MENU_DROPDOWN = Target.the("menu dropdown button").located(By.cssSelector("a.dropdown-toggle"));
    public static Target LOGOUT = Target.the("logout link").located(By.cssSelector("#signout-button button"));
}
