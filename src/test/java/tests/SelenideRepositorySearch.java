package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSampleCodeForJUnit5() {

        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденых
        $$("[data-testid='results-list']").first().$("a").click();
        //найти раздел Wiki проекта и перейти в него
        $("#wiki-tab").click();
        //найти в списке страниц Soft Assertions и  перейти на нее
        $$("ul li a").findBy(text("Soft assertions")).click();

        //проверка наличия заголовка, содержащего JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
        //проверка в коде наличия анатации, используемой для в JUnit 5
        $("body").shouldHave(text("@ExtendWith"));




    }
}
