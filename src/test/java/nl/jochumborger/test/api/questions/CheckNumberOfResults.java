package nl.jochumborger.test.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;
import nl.jochumborger.test.api.abilities.UseTheApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jochum on 08/07/16.
 */
public class CheckNumberOfResults implements Question<Boolean> {

    private int number;
    private Operator operator;

    protected CheckNumberOfResults(int number, Operator operator) {
        this.number = number;
        this.operator = operator;
    }

    public static Question<Boolean> exactly(int number) {
        return new CheckNumberOfResults(number, Operator.EQ);
    }

    public static Question<Boolean> moreThan(int number) {
        return new CheckNumberOfResults(number, Operator.GT);
    }

    public static Question<Boolean> lessThan(int number) {
        return new CheckNumberOfResults(number, Operator.LT);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> queryResult = new ArrayList<>();
        try {
            queryResult = UseTheApi.as(actor).getQueryResultAsList();
        } catch (UseTheApi.ActorCannotUseTheApiException e) {
            e.printStackTrace();
        }

        Boolean result = false;
        int numTweets = queryResult.size();

        switch(operator) {
            case EQ:
                result = number == numTweets;
                break;
            case GT:
                result = number < numTweets;
                break;
            case LT:
                result = number > numTweets;
                break;
            default:
                break;
        }

        return result;
    }

    private enum Operator {
        EQ, GT, LT;
    }
}
