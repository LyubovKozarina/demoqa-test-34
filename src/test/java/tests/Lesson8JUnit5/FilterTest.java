package tests.Lesson8JUnit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tests.demoqa.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.Lesson8JUnit5.TestBase.baseUrl;


public class FilterTest {
    @ParameterizedTest
    @EnumSource(Category.class)
    void testFilterFunctionality(Category category) {
        open(baseUrl);
        $("a[href*='" + category.name().toLowerCase()+"']").click();
        $(".page-title").shouldHave(text(category.name()));
    }

}
