package nl.jochumborger.test.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import nl.jochumborger.test.web.ui.TwitterHomePage;

/**
 * Created by jochum on 08/07/16.
 */
public class OpenTwitter implements Task {

    TwitterHomePage twitterHomePage;

    @Step("Open twitter")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(twitterHomePage)
        );
    }

}
