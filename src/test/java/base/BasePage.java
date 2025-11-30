package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;


public class BasePage extends LinksPage {
    @BeforeEach
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Selenide.open(LinksPage.helpDeskUrl);
    }
}
