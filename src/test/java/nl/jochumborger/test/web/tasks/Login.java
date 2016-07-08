package nl.jochumborger.test.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import nl.jochumborger.test.web.ui.LoginBox;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 08/07/16.
 */
public class Login implements Task {

    private final String username;
    private final String password;

    protected Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Step("Login on twitter with #username")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username)
                        .into(LoginBox.USERNAME_FIELD),
                Enter.theValue(password)
                        .into(LoginBox.PASSWORD_FIELD),
                Click.on(LoginBox.LOGIN_BUTTON)
        );
    }

    public static Performable withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }
}
