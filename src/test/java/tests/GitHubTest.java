package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {
    @Test
    void shouldOpenEnterprisePage() {
        open("https://github.com/");
        $$("ul li").findBy(text("Solutions")).hover();
        $$("ul li a").findBy(text("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" +
                "developer platform"
        ));
    }
}
