package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.DatePicker;
import pages.components.ModalDialog;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {
    private final SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            phone = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit");

    private final DatePicker datePicker = new DatePicker();
    private final ModalDialog modalDialog = new ModalDialog();

    public FormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public FormPage removeBanner() {
        executeJavaScript("document.querySelectorAll('#fixedban, footer, iframe').forEach(el => el.remove())");
        waitUntilIframesGone();
        return this;
    }

    private void waitUntilIframesGone() {
        for (int i = 0; i < 10; i++) {
            if ($$("iframe").isEmpty()) break;
            sleep(500);
            executeJavaScript("document.querySelectorAll('iframe').forEach(el => el.remove())");
        }
    }


    public FormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public FormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public FormPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public FormPage selectGender(String gender) {
        $$("label").findBy(text(gender)).click();
        return this;
    }

    public FormPage setPhone(String value) {
        phone.setValue(value);
        return this;
    }

    public FormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        datePicker.setDate(day, month, year);
        return this;
    }

    public FormPage setSubject(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    public FormPage selectHobby(String hobby) {
        $$("label").findBy(text(hobby)).scrollIntoView(true).click();
        return this;
    }

    public FormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public FormPage setAddress(String value) {
        address.setValue(value);
        return this;
    }

    public FormPage selectStateAndCity(String stateValue, String cityValue) {
        state.click();
        $(byText(stateValue)).click();
        city.click();
        $(byText(cityValue)).click();
        return this;
    }

    public FormPage submit() {
        $("#submit").scrollTo().click();
        return this;
    }

    public ModalDialog getModalDialog() {
        return modalDialog;
    }

    public void verifyRedBorderForRequiredFields() {
        firstName.shouldHave(cssValue("border-color", "rgb(206, 212, 218)"));
        lastName.shouldHave(cssValue("border-color", "rgb(206, 212, 218)"));
        phone.shouldHave(cssValue("border-color", "rgb(206, 212, 218)"));
    }
}