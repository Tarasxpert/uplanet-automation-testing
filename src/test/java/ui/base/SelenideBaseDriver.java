package ui.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public class SelenideBaseDriver {
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        System.setProperty("selenide.screenshots", "false");
//        Configuration.reportsFolder = "${project.build.directory}/allure-results";
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Before
    public void init() {
        setUp();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}