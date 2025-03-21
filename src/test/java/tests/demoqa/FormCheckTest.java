package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.FormPage;

public class FormCheckTest extends TestBase {
    private final FormPage formPage = new FormPage();
    private final TestData testData = new TestData();

    @Test
    void fillFormTest() {
        formPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .selectGender(testData.gender)
                .setPhone(testData.phoneNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .selectHobby(testData.hobby)
                .uploadPicture(TestData.picture)
                .setAddress(testData.address)
                .selectStateAndCity(testData.state, testData.city)
                .submit();

        formPage.getModalDialog().verifyModalTitle("Thanks for submitting the form");
        formPage.getModalDialog().verifyField(testData.firstName + " " + testData.lastName);
        formPage.getModalDialog().verifyField(testData.email);
        formPage.getModalDialog().verifyField(testData.gender);
        formPage.getModalDialog().verifyField(testData.phoneNumber);
        formPage.getModalDialog().verifyField(testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear);
        formPage.getModalDialog().verifyField(testData.subject);
        formPage.getModalDialog().verifyField(testData.hobby);
        formPage.getModalDialog().verifyField(TestData.picture);
        formPage.getModalDialog().verifyField(testData.address);
        formPage.getModalDialog().verifyField(testData.state + " " + testData.city);
    }

}

