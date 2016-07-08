package nl.jochumborger.test.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import nl.jochumborger.test.web.ui.UserInformation;

/**
 * Created by jochum on 08/07/16.
 */
public class TwitterHandle implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(UserInformation.TWITTER_HANDLE).viewedBy(actor).asString();
    }
}
