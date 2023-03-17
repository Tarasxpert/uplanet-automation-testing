package ui.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;
import ui.base.SelenideBaseDriver;
import ui.pages.UranMainPage;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MainTest extends SelenideBaseDriver {
    @Test(description= "Main page UI TEST of https://urancompany.com/", enabled = true)
    @Owner("Taras Zelenskyi")
    @Description("Visiting Main page of Uran and checking if all the DIVs are displayed and visible.")
    public void DomTest() {
        UranMainPage uranMainPage = new UranMainPage();
        uranMainPage.openPage("https://urancompany.com/");
        assertTrue(uranMainPage.divWhoWeAreIsDisplayed());
        System.out.println("Div 'WhoWeAre' found");
        assertTrue(uranMainPage.divWhatWeDoIsDisplayed());
        System.out.println("Div 'WhatWeDo' found");
        assertTrue(uranMainPage.divExpertiseIsDisplayed());
        System.out.println("Div 'Expertise' found");
        assertTrue(uranMainPage.divOurApproachIsDisplayed());
        System.out.println("Div 'OurApproachIs' found");
        assertTrue(uranMainPage.divWhatComesOutIsDisplayed());
        System.out.println("Div 'WhatComesOut' found");
        uranMainPage.findFooterText();
        uranMainPage.assertFooterText("© 2006-2023 Uran, All rights reserved");
        System.out.println("Assert passed");
        int i = 1;
        do {
            uranMainPage.takescreenshotF(i);
            executeJavaScript("return window.scrollBy(0, 1000);");
            i++;
            sleep(500);
        } while (!atBottom());
        uranMainPage.takescreenshotF(i);


    }

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
