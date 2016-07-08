package nl.jochumborger.test.features.search;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Steps;
import nl.jochumborger.test.api.abilities.UseTheApi;
import nl.jochumborger.test.api.tasks.ConnectToTwitter;
import nl.jochumborger.test.api.questions.CheckNumberOfResults;
import nl.jochumborger.test.api.tasks.Search;
import org.junit.Before;
import org.junit.Test;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

/**
 * Created by jochum on 08/07/16.
 */
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
        then(lexie).should(seeThat(CheckNumberOfResults.moreThan(0)));
    }

}
