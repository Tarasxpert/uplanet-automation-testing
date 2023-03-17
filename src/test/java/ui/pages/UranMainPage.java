package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class UranMainPage {

    private final SelenideElement divWhoWeAre = $(By.id("WhoWeAre"));
    private final SelenideElement divWhatWeDo = $(By.id("WhatWeDo"));
    private final SelenideElement divExpertise = $(By.id("Expertise"));
    private final SelenideElement divOurApproach = $(By.id("OurApproach"));
    private final SelenideElement divWhatComesOut = $(By.id("WhatComesOut"));
    private final SelenideElement formName = $(By.id("form-name"));
    private final SelenideElement formEmail = $(By.id("form-email"));
    private final SelenideElement formMessage = $(By.id("form-message"));
    private final SelenideElement footerText = $x("//*[@id=\"gatsby-focus-wrapper\"]/div/footer/div/div[2]/div[3]/p");

    @Step("Open main page")
    public void openPage(String url) {open(url);}

    @Step("Checking if div 'WhoWeAre' is visible")
    public boolean divWhoWeAreIsDisplayed() {
        return divWhoWeAre.isDisplayed();
    }

    @Step("Checking if div 'WhatWeDo' is visible")
    public boolean divWhatWeDoIsDisplayed() {
        return divWhatWeDo.isDisplayed();
    }

    @Step("Checking if div 'Expertise' is visible")
    public boolean divExpertiseIsDisplayed() {
        return divExpertise.isDisplayed();
    }

    @Step("Checking if div 'OurApproach' is visible")
    public boolean divOurApproachIsDisplayed() {
        return divOurApproach.isDisplayed();
    }

    @Step("Checking if div 'WhatComesOut' is visible")
    public boolean divWhatComesOutIsDisplayed() {
        return divWhatComesOut.isDisplayed();
    }

    @Step("Fulfill Name in form")
    public void fulfillName(String name) {
        formName.setValue(name);
    }

    @Step("Fulfill Email in form")
    public void fulfillEmail(String email) {
        formEmail.setValue(email);
    }

    @Step("Fulfill Message in form")
    public void fulfillMessage(String message) {
        formMessage.setValue(message);
    }

    @Step("Taking screenshot of form")
    public void takescreenshot() {
        Allure.addAttachment("Form Screenshot", new ByteArrayInputStream(screenshot(OutputType.BYTES)));
    }

    @Step("Taking screenshot of footer")
    public void takescreenshotF() {
        Allure.addAttachment("Form Screenshot", new ByteArrayInputStream(screenshot(OutputType.BYTES)));
    }

    @Step("Footer is displayed")
    public void findFooterText() {
        footerText.shouldBe(Condition.visible);
    }

    @Step("Matching footer text (should be exactly '{texting}')")
    public void assertFooterText(String texting) {
        String text = footerText.getText();
        assertEquals(text,texting);
    }
}
