package tests.lesson8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchTest extends TestBase {
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек")
    @ValueSource(strings = {"Laptop", "Phone", "Desktop"})
    void shouldDisplaySearchResultsForValidQuery(String query) {
        $("#small-searchterms").setValue(query).pressEnter();
        $(".search-results").should(appear);
        $(".search-results").shouldHave(text(query));
    }
}
