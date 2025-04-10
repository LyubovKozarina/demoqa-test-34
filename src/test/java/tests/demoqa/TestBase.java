package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 5000;

        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "120.0");
        String remoteUrl = System.getProperty("remoteUrl", "");
        String screenResolution = System.getProperty("screenResolution", "");

        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;

        if (!remoteUrl.isBlank()) {
            Configuration.remote = remoteUrl;
        }

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", true);

        if (!screenResolution.isBlank()) {
            selenoidOptions.put("screenResolution", screenResolution);
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", selenoidOptions);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
