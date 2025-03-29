package tests.Lesson8JUnit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchTest extends TestBase {
    @ParameterizedTest
    @ValueSource(strings = {"Laptop", "Phone", "Desktop"})
    void SearchFunctionalityTest(String query) {
        $("#small-searchterms").setValue(query).pressEnter();
        $(".search-results").should(appear);
        $(".search-results").shouldHave(text(query));
    }
}
