package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ui.base.SelenideBaseDriver;
import ui.pages.UranMainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class FormTest extends SelenideBaseDriver {

    @Test(description= "'Ping Us' form TEST of https://urancompany.com/", enabled = true)
    @Owner("Taras Zelenskyi")
    @Description("Fulfilling main page form 'Ping Us' and checking if .... (this will be next task)")
    @Link("https://urancompany.com/")
    public void FormTest() {
        UranMainPage uranMainPage = new UranMainPage();
        uranMainPage.openPage("https://urancompany.com/");
        uranMainPage.fulfillName("Example");
        System.out.println("Name Filled");
        uranMainPage.fulfillEmail("Example@mail.com");
        System.out.println("Email Filled");
        uranMainPage.fulfillMessage("ExampleMes");
        System.out.println("Message Filled");
        uranMainPage.takescreenshot();
        System.out.println("Screenshot taken");


    }
}
