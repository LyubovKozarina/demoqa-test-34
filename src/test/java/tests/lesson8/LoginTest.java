package tests.lesson8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends TestBase {
    @ParameterizedTest(name = "Проверяет успешный логин пользователя с Email={0}")
    @CsvSource({
            "0123@yandex.ru, 0123@yandex.ru",
            "4567@yandex.ru, 4567@yandex.ru",
            "8910@yandex.ru, 8910@yandex.ru"
    })
    void shouldLoginSuccessfullyWithValidCredentials(String email, String password) {
        open(baseUrl + "/login");
        $("#Email").setValue(email);
        $("#Password").setValue(password);
        $("input[value='Log in']").click();
        $(".account").shouldHave(text(email));
    }
}
