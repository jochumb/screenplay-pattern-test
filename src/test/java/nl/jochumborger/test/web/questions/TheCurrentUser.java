package nl.jochumborger.test.web.questions;

import net.serenitybdd.screenplay.Question;

/**
 * Created by jochum on 08/07/16.
 */
public class TheCurrentUser {

    public static Question<String> username() { return new Username(); }
    public static Question<String> twitterHandle() { return new TwitterHandle(); }

}
