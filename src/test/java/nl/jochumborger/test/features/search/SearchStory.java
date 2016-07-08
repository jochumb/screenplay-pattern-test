package nl.jochumborger.test.features.search;

import net.serenitybdd.screenplay.Actor;
import nl.jochumborger.test.api.abilities.UseTheApi;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jochum on 08/07/16.
 */
public class SearchStory {

    Actor lexie = Actor.named("Lexie");

    @Before
    public void lexieCanUseTheApi() {
        lexie.can(UseTheApi.withDefaultContext());
    }

    @Test
    public void search_twitter_via_api_should_contain_expected_resuls() {
    }

}
