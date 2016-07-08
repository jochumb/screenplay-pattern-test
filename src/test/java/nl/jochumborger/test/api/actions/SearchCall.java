package nl.jochumborger.test.api.actions;

import net.serenitybdd.screenplay.Action;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by jochum on 08/07/16.
 */
public class SearchCall implements Action {

    private final String query;

    public SearchCall(String query) {
        this.query = query;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }
}
