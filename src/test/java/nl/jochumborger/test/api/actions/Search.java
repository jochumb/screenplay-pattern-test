package nl.jochumborger.test.api.actions;

import net.serenitybdd.screenplay.Action;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import nl.jochumborger.test.api.abilities.UseTheApi;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 08/07/16.
 */
public class Search implements Action {

    private final String query;

    public Search(String query) {
        this.query = query;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            UseTheApi.as(actor).searchFor(query);
        } catch (UseTheApi.ActorCannotUseTheApiException e) {
            e.printStackTrace();
        }
    }

    public static Performable forText(String searchquery) {
        return instrumented(Search.class, searchquery);
    }
}
