package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ui.base.SelenideBaseDriver;
import ui.pages.UplanetMainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class UplanetDOMTest extends SelenideBaseDriver {


    @Test(description= "Uplanet DOM Test")
    @Owner("Taras Zelenskyi")
    @Description("Visiting Main page of Uran and checking if all the DIVs are displayed and visible.")
    public void DomTest() {
        int i = 1;
        UplanetMainPage uplanetMainPage = new UplanetMainPage();
        uplanetMainPage.openMainPage("https://uplanet.biz");
        assertTrue(uplanetMainPage.divWelcomeIsDisplayed());
        System.out.println("Div 'Welcome' is found and displayed;");
        assertTrue(uplanetMainPage.divServiceIsDisplayed());
        System.out.println("Div 'Service' is found and displayed;");
        assertTrue(uplanetMainPage.sectionPortfolioIsDisplayed());
        System.out.println("Section 'Portfolio' is found and displayed;");
        assertTrue(uplanetMainPage.divTestimonialIsDisplayed());
        System.out.println("Div 'Testimonial' is found and displayed;");
        assertTrue(uplanetMainPage.divContactIsDisplayed());
        System.out.println("Div 'Contact' is found and displayed;");
        assertTrue(uplanetMainPage.divFooterIsDisplayed());
        System.out.println("Div 'Footer' is found and displayed;");
        assertTrue(uplanetMainPage.divCopyrightIsDisplayed());
        System.out.println("Div 'Copyright' is found and displayed;");
        uplanetMainPage.assertFooterText("© 2008-2023 UPlanet. All Rights Reserved.");
        System.out.println("Text assertion passed!");
        sleep(5000);
        uplanetMainPage.takescreenshotF(i);
        do {
            executeJavaScript("return window.scrollBy(0, 1000);");
            sleep(100);
        } while (!atBottom());
        i++;
        uplanetMainPage.takescreenshotF(i);


    }

}
