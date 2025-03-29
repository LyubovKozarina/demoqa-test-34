package tests.Lesson8JUnit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FilterTest extends TestBase{
    @ParameterizedTest(name = "Проверяет работу фильтрация товаров по категории {0}")
    @EnumSource(Category.class)
    void testFilterFunctionality(Category category) {
        $("a[href*='" + category.name().toLowerCase()+"']").click();
        $(".page-title").shouldHave(text(category.name()));
    }

}
