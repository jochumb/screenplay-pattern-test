package nl.jochumborger.test.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import nl.jochumborger.test.api.abilities.UseTheApi;

/**
 * Created by jochum on 08/07/16.
 */
public class ConnectToTwitter implements Task {

    @Step("Connect to twitter via Api")
    public <T extends Actor> void performAs(T actor) {
        UseTheApi.as(actor);
    }

}
