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
        int i = 1;

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
        sleep(5000);
        uranMainPage.takescreenshotF(i);
        do {
            executeJavaScript("return window.scrollBy(0, 1000);");
            sleep(100);
        } while (!atBottom());
        i++;
        uranMainPage.takescreenshotF(i);


    }

}
