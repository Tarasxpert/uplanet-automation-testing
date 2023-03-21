package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ui.pages.UranMainPage;

import static com.codeborne.selenide.Selenide.sleep;

public class UranFormTest {
    @Test(description= "Uran Contact Form Test")
    @Owner("Taras Zelenskyi")
    @Description("Fulfilling main page form 'Ping Us' and checking if .... (this will be next task)")
    @Link("https://urancompany.com/")
    public void FormTest() {
        UranMainPage uranMainPage = new UranMainPage();
        uranMainPage.openPage("https://urancompany.com/");
        uranMainPage.fulfillName("Example");
        System.out.println("Name Filled");
        uranMainPage.fulfillEmail("2");
        System.out.println("Email Filled");
        uranMainPage.fulfillMessage("ExampleMes");
        System.out.println("Message Filled");
        uranMainPage.clickSubmit();
        System.out.println("Submit clicked");
        sleep(100);
        uranMainPage.takescreenshot();
        System.out.println("Screenshot taken");
    }
}
