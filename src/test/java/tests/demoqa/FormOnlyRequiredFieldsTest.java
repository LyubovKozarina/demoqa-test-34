package tests.demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import static io.qameta.allure.Allure.step;

public class FormOnlyRequiredFieldsTest extends TestBase {
    private final FormPage formPage = new FormPage();
    private final TestData testData = new TestData();

    @Test
    @Tag("demoqa")
    void fillFormIncompleteTest() {
        step("Open form", () -> {
            formPage.openPage()
                    .removeBanner();
        });
        step("Fill required fields", () -> {
            formPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .selectGender(testData.gender)
                    .setPhone(testData.phoneNumber)
                    .submit();
        });
        step("Verify results", () -> {
            formPage.getModalDialog().verifyModalTitle("Thanks for submitting the form");
            formPage.getModalDialog().verifyField(testData.firstName + " " + testData.lastName);
            formPage.getModalDialog().verifyField(testData.gender);
            formPage.getModalDialog().verifyField(testData.phoneNumber);
        });
    }
}

