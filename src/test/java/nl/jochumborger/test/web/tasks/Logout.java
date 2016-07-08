package nl.jochumborger.test.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import nl.jochumborger.test.web.actions.JsClick;
import nl.jochumborger.test.web.ui.UserMenu;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 08/07/16.
 */
public class Logout implements Task {

    public static Performable now() {
        return instrumented(Logout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JsClick.on(UserMenu.MENU_DROPDOWN),
                Click.on(UserMenu.LOGOUT)
        );
    }
}
