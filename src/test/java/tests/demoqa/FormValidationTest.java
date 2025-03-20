package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.FormPage;

public class FormValidationTest extends TestBase {
    private final FormPage formPage = new FormPage();

    @Test
    void requiredFieldsValidationTest() {
        formPage.openPage()
                .removeBanner()
                .submit();

        formPage.verifyRedBorderForRequiredFields();
    }
}
