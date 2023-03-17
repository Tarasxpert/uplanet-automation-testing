package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ui.base.SelenideBaseDriver;
import ui.pages.UranMainPage;

import static com.codeborne.selenide.Selenide.screenshot;
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
        uranMainPage.fulfillName("Example");
        uranMainPage.fulfillEmail("Example@mail.com");
        uranMainPage.fulfillMessage("ExampleMes");
        String pngFileName = screenshot("Site_form");
    }
}
