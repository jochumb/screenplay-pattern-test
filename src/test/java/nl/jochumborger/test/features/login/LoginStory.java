package nl.jochumborger.test.features.login;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import nl.jochumborger.test.twitter.User;
import nl.jochumborger.test.web.questions.TheCurrentUser;
import nl.jochumborger.test.web.tasks.Login;
import nl.jochumborger.test.web.tasks.Logout;
import nl.jochumborger.test.web.tasks.OpenTwitter;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by jochum on 08/07/16.
 */
@RunWith(SerenityRunner.class)
public class LoginStory {

    User twitterUser = User.getInstance();

    Actor lexie = Actor.named("Lexie");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTwitter openTwitter;

    @Before
    public void lexieCanBrowseTheWeb() {
        lexie.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void log_in_with_correct_credentials_should_show_twitter_feed() {
        givenThat(lexie).wasAbleTo(openTwitter);

        when(lexie).attemptsTo(Login.withCredentials(twitterUser.getUsername(),twitterUser.getPassword()));

        then(lexie).should(
                eventually(seeThat(TheCurrentUser.username(), containsString(twitterUser.getDisplayName()))),
                seeThat(TheCurrentUser.twitterHandle(), containsString(twitterUser.getHandle()))
        );
    }

    @After
    public void logout() {
        lexie.attemptsTo(Logout.now());
    }

}
