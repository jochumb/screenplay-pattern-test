package nl.jochumborger.test.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import nl.jochumborger.test.api.abilities.UseTheApi;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 11/07/16.
 */
public class Search implements Task {

    private String searchQuery;

    protected Search(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Step("Search for text")
    public <T extends Actor> void performAs(T actor) {
        UseTheApi.as(actor).searchFor(searchQuery);
    }

    public static Performable forText(String searchQuery) {
        return instrumented(Search.class, searchQuery);
    }
}
