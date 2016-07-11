package nl.jochumborger.test.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;
import nl.jochumborger.test.api.abilities.UseTheApi;
import nl.jochumborger.test.api.tasks.ConnectToTwitter;
import nl.jochumborger.test.api.questions.NumberOfResults;
import nl.jochumborger.test.api.tasks.Search;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by jochum on 08/07/16.
 */
@RunWith(SerenityRunner.class)
public class SearchStory {

    Actor lexie = Actor.named("Lexie");

    @Steps
    ConnectToTwitter connectToTwitter;

    @Before
    public void lexieCanUseTheApi() {
        lexie.can(UseTheApi.withDefaultContext());
    }

    @Test
    public void search_twitter_via_api_should_contain_expected_results() {
        givenThat(lexie).wasAbleTo(connectToTwitter);
        when(lexie).attemptsTo(Search.forText("#test"));
        then(lexie).should(seeThat(NumberOfResults.count(), greaterThan(0))); //assumption that "#test" is regularly used
    }

}
