package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormCheckTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan@ivanov.com");
        $$("label").findBy(text("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--028").click();
        $("#subjectsInput").setValue("Ma").pressEnter();
        $$("label").findBy(text("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();



        $(".modal-content").shouldBe(visible);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Ivan" + " " + "Ivanov"));
        $(".modal-content").shouldHave(text("ivan@ivanov.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("1234567890"));
        $(".modal-content").shouldHave(text("28" + " " + "February" + "," + "2000"));
        $(".modal-content").shouldHave(text("Maths"));
        $(".modal-content").shouldHave(text("Music"));
        $(".modal-content").shouldHave(text("test.jpg"));
        $(".modal-content").shouldHave(text("Some street 1"));
        $(".modal-content").shouldHave(text("Haryana" + " " + "Karnal"));









    }


}
