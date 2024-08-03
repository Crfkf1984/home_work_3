import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MouseHoverMove {

    @BeforeAll
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\.cache\\selenium\\chromedriver\\win64\\126.0.6478.126\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void mouseMoveTest() {
        open("https://github.com");
        $$(".HeaderMenu-item").get(1).shouldHave(Condition.text("Solutions")).hover();
        $$(".border-bottom ul li").get(0).$("a").click();
        $("[data-testid='Grid-:Ra9b:']").shouldHave(text("The AI-powered developer platform."));
    }

    @Test
    public void dragAndDropTest() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        open("/drag_and_drop");
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-b").shouldHave(text("A"));
    }
}