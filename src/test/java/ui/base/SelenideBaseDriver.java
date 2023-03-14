package ui.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static configs.Configs.CLOUDCAMPAIGN_CREDENTIALS_CONFIG;

public class SelenideBaseDriver {
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 60000;
        System.setProperty("selenide.screenshots", "false");
        Configuration.baseUrl = CLOUDCAMPAIGN_CREDENTIALS_CONFIG.url;
        Configuration.reportsFolder = "target/allure-results";
        addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}