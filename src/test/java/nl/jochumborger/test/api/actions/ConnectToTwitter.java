package nl.jochumborger.test.api.actions;

import net.serenitybdd.screenplay.Action;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import nl.jochumborger.test.api.abilities.UseTheApi;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 08/07/16.
 */
public class ConnectToTwitter implements Action {

    @Step("Connect to twitter via Api")
    public <T extends Actor> void performAs(T actor) {
        try {
            UseTheApi.as(actor);
        } catch (UseTheApi.ActorCannotUseTheApiException e) {
            e.printStackTrace();
        }
    }

    public static Performable now() {
        return instrumented(ConnectToTwitter.class);
    }
}
