package nl.jochumborger.test.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by jochum on 08/07/16.
 */
public class UserInformation {
    public static Target USERNAME = Target.the("twitter username").located(By.cssSelector(".DashboardProfileCard-name a"));
    public static Target TWITTER_HANDLE = Target.the("twitter handle").located(By.cssSelector(".DashboardProfileCard-screenname a span"));
}
