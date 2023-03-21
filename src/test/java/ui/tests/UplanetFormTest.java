package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ui.base.SelenideBaseDriver;
import ui.pages.UplanetMainPage;

import static com.codeborne.selenide.Selenide.*;

public class UplanetFormTest extends SelenideBaseDriver {


    @Test(description= "Uplanet Contact Form Test")
    @Owner("Taras Zelenskyi")
    @Description("Fulfilling main page Contact form and checking if .... (this will be next task)")
    @Link("https://uplanet.biz/")
    public void FormTest() {
        UplanetMainPage uplanetMainPage = new UplanetMainPage();
        uplanetMainPage.openMainPage("https://uplanet.biz/?form=contact-form-test");
        sleep(5000);
        System.out.println("MainPage is opened;");
        uplanetMainPage.fulfillName("QA");
        System.out.println("Name fulfilled;");
        uplanetMainPage.fulfillEmail("uran.tester@gmail.com");
        System.out.println("Email fulfilled;");
        uplanetMainPage.fulfillCompany("Uplanet");
        System.out.println("Company fulfilled;");
        uplanetMainPage.fulfillMessage("Test message");
        System.out.println("Message fulfilled;");
        uplanetMainPage.checkingCheckbox();
        System.out.println("Checkbox making visible and been checked;");
        uplanetMainPage.clickSubmitButton();
        System.out.println("Submit button clicked;");
        uplanetMainPage.takescreenshot();
    }
}
