package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.FormPage;

public class FormCheckTest extends TestBase {
    private final FormPage formPage = new FormPage();

    @Test
    void fillFormTest() {
        formPage.openPage()
                .removeBanner()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivan@ivanov.com")
                .selectGender()
                .setPhone("1234567890")
                .setDateOfBirth("28", "February", "2000")
                .setSubject("Maths")
                .selectHobby()
                .uploadPicture("test.jpg")
                .setAddress("Some street 1")
                .selectStateAndCity("Haryana", "Karnal")
                .submit();

        formPage.getModalDialog().verifyModalTitle("Thanks for submitting the form");
        formPage.getModalDialog().verifyField("Ivan Ivanov");
        formPage.getModalDialog().verifyField("ivan@ivanov.com");
        formPage.getModalDialog().verifyField("Male");
        formPage.getModalDialog().verifyField("1234567890");
        formPage.getModalDialog().verifyField("28 February,2000");
        formPage.getModalDialog().verifyField("Maths");
        formPage.getModalDialog().verifyField("Music");
        formPage.getModalDialog().verifyField("test.jpg");
        formPage.getModalDialog().verifyField("Some street 1");
        formPage.getModalDialog().verifyField("Haryana Karnal");
    }
}
