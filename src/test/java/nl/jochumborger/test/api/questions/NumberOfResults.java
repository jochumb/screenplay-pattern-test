package nl.jochumborger.test.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import nl.jochumborger.test.api.abilities.UseTheApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jochum on 08/07/16.
 */
public class NumberOfResults implements Question<Integer> {

    public static Question<Integer> count() { return new NumberOfResults(); }

    public Integer answeredBy(Actor actor) {
        List<String> queryResult = UseTheApi.as(actor).getQueryResultAsList();
        return queryResult.size();
    }
}
