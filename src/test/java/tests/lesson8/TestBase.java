package tests.lesson8;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    static final String baseUrl = "https://demowebshop.tricentis.com";

    @BeforeEach
    void setUp() {
        Selenide.open(baseUrl);
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}


