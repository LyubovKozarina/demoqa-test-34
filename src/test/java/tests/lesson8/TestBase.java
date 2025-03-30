package tests.lesson8;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeAll
    static void setUpClass() {
        Configuration.baseUrl = "https://demowebshop.tricentis.com";
    }

    @BeforeEach
    void setUp() {
        Selenide.open(Configuration.baseUrl);
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}


