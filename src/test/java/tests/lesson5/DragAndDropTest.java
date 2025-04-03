package tests.lesson5;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DragAndDropTest {

    @Test
    void shouldMovingRectangleTest() {
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        Actions actions = Selenide.actions();
        actions.dragAndDrop($("#column-a").toWebElement(), $("#column-b").toWebElement()).perform();
        //$("#column-a").dragAndDropTo($("#column-b")); //не работает
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}

