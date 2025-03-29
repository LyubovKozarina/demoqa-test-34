package tests.Lesson8JUnit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.demoqa.TestBase;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.Lesson8JUnit5.TestBase.baseUrl;


public class SearchTest {
    @ParameterizedTest
    @ValueSource(strings = {"Laptop", "Phone", "Desktop"})
    void SearchFunctionalityTest(String query) {
        open(baseUrl);
        $("#small-searchterms").setValue(query).pressEnter();
        $(".search-results").should(appear);
        $(".search-results").shouldHave(text(query));
    }
}
