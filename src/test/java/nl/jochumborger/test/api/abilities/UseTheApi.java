package nl.jochumborger.test.api.abilities;

import net.serenitybdd.core.eventbus.Broadcaster;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import nl.jochumborger.test.api.exceptions.ActorCannotUseTheApiException;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jochum on 08/07/16.
 */
public class UseTheApi implements Ability {

    private Actor actor;
    private Twitter twitter;

    private QueryResult queryResult;

    public UseTheApi() {
        twitter = TwitterFactory.getSingleton();
        Broadcaster.getEventBus().register(this);
    }

    public static UseTheApi withDefaultContext() {
        return new UseTheApi();
    }

    public static UseTheApi as(Actor actor) {
        if (actor.abilityTo(UseTheApi.class) == null) {
            throw new ActorCannotUseTheApiException(actor.getName());
        }
        return actor.abilityTo(UseTheApi.class).asActor(actor);
    }

    public Twitter getApi() {
        return twitter;
    }

    @Override
    public <T extends Ability> T asActor(Actor actor) {
        this.actor = actor;
        return (T) this;
    }

    public void searchFor(String query) {
        try {
            queryResult = twitter.search(new Query(query));
        } catch (TwitterException e) {
            e.printStackTrace(); //TODO: throw runtime exception
        }
    }

    public List<String> getQueryResultAsList() {
        List<String> resultList = new ArrayList<>();
        for (Status status : queryResult.getTweets()) {
           resultList.add(status.getText());
        }
        return resultList;
    }
}
