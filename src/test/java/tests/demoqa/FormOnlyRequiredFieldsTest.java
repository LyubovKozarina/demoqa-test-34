package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.FormPage;

public class FormOnlyRequiredFieldsTest extends TestBase {
    private final FormPage formPage = new FormPage();

    @Test
    void fillFormIncompleteTest() {
        formPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .selectGender()
                .setPhone("1234567890")
                .submit();

        formPage.getModalDialog().verifyModalTitle("Thanks for submitting the form");
        formPage.getModalDialog().verifyField("Ivan Ivanov");
        formPage.getModalDialog().verifyField("Male");
        formPage.getModalDialog().verifyField("1234567890");
    }
}