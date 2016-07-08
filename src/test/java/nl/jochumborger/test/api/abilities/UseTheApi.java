package nl.jochumborger.test.api.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * Created by jochum on 08/07/16.
 */
public class UseTheApi implements Ability {

    private Actor actor;
    private Twitter twitter;

    public UseTheApi() {
        twitter = TwitterFactory.getSingleton();
    }

    public static UseTheApi withDefaultContext() {
        return new UseTheApi();
    }

    @Override
    public <T extends Ability> T asActor(Actor actor) {
        this.actor = actor;
        return (T) this;
    }

}
