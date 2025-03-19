package pages.components;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ModalDialog {
    private  SelenideElement modalContent = $(".modal-content");

    public void verifyModalTitle(String expectedText) {
        modalContent.shouldHave(text(expectedText));
    }

    public void verifyField(String expectedText) {
        modalContent.shouldHave(text(expectedText));
    }
}