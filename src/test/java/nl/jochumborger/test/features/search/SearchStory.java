package nl.jochumborger.test.features.search;

import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;
import nl.jochumborger.test.api.abilities.UseTheApi;
import nl.jochumborger.test.api.actions.ConnectToTwitter;
import nl.jochumborger.test.api.questions.CheckNumberOfResults;
import nl.jochumborger.test.api.actions.Search;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

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
    @Ignore
    public void search_twitter_via_api_should_contain_expected_results() {
        System.out.println("TestSystemout");
        givenThat(lexie).wasAbleTo(ConnectToTwitter.now());
        when(lexie).attemptsTo(Search.forText("#test"));
        then(lexie).should(seeThat(CheckNumberOfResults.exactly(0)));
    }

}
