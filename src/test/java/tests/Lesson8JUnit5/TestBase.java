package tests.Lesson8JUnit5;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    static final String baseUrl = "https://demowebshop.tricentis.com";

    @BeforeEach
    void setUp() {
        Selenide.open(baseUrl);
    }
}
