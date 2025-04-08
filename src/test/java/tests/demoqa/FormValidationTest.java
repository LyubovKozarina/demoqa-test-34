package tests.demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import static io.qameta.allure.Allure.step;

public class FormValidationTest extends TestBase {
    private final FormPage formPage = new FormPage();

    @Test
    @Tag("demoqa")
    void requiredFieldsValidationTest() {
        step("Open form", () -> {
            formPage.openPage()
                    .removeBanner();
        });
        step("Verify red border for required fields", () -> {
            formPage.verifyRedBorderForRequiredFields();
        });
    }
}
