package tests.Lesson8JUnit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.demoqa.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.Lesson8JUnit5.TestBase.baseUrl;

public class LoginTest {
    @ParameterizedTest
    @CsvSource({
    "0123@yandex.ru, 0123@yandex.ru ",
    "4567@yandex.ru, 4567@yandex.ru",
    "8910@yandex.ru, 8910@yandex.ru "
    })
    void LoginFunctionalityTest(String email, String password) {
        open(baseUrl + "/login");;
        $("#Email").setValue(email);
        $("#Password").setValue(password);
        $("input[value='Log in']").click();
        $(".account").shouldHave(text(email));
    }
}
