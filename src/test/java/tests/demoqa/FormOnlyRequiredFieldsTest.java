package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.FormPage;

public class FormOnlyRequiredFieldsTest extends TestBase {
    private final FormPage formPage = new FormPage();
    private final TestData testData = new TestData();

    @Test
    void fillFormIncompleteTest() {
        formPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .selectGender(testData.gender)
                .setPhone(testData.phoneNumber)
                .submit();

        formPage.getModalDialog().verifyModalTitle("Thanks for submitting the form");
        formPage.getModalDialog().verifyField(testData.firstName + " " + testData.lastName);
        formPage.getModalDialog().verifyField(testData.gender);
        formPage.getModalDialog().verifyField(testData.phoneNumber);
    }
}

