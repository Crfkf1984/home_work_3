import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
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
}