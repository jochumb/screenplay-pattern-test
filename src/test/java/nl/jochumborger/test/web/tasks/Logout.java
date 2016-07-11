package nl.jochumborger.test.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import nl.jochumborger.test.web.actions.JsClick;
import nl.jochumborger.test.web.ui.UserMenu;

/**
 * Created by jochum on 08/07/16.
 */
public class Logout implements Task {

    @Step("Logout from Twitter")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JsClick.on(UserMenu.MENU_DROPDOWN),
                Click.on(UserMenu.LOGOUT)
        );
    }
}
