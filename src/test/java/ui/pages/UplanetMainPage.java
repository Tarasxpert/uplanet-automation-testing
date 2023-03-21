package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class UplanetMainPage {
    private final SelenideElement divWelcome= $(By.id("welcome"));
    private final SelenideElement divService= $(By.id("service"));
    private final SelenideElement sectionPortfolio= $(By.id("portfolio"));
    private final SelenideElement divTestimonial= $(By.id("testimonial"));
    private final SelenideElement divContact= $(By.id("contact"));
    private final SelenideElement divFooter = $(By.id("footer"));
    private final SelenideElement divCopyright = $(By.id("copyright"));
    private final SelenideElement inputFieldName = $(By.id("contact-name"));
    private final SelenideElement inputFieldEmail = $(By.id("contact-email"));
    private final SelenideElement inputFieldCompany = $(By.id("contact-company"));
    private final SelenideElement textAreaFieldMessage = $(By.id("contact-message"));
    private final SelenideElement checkBox = $(By.id("contact-privacy"));
    private final SelenideElement submitButton = $x("//button[@type=\"submit\"]");
    private final SelenideElement footerText = $x("//*[@id=\"copyright\"]/p");

    @Step("Open main page")
    public void openMainPage(String url) {open(url);}

    @Step("Checking if div 'Welcome' is visible")
    public boolean divWelcomeIsDisplayed(){return divWelcome.isDisplayed();}

    @Step("Checking if div 'Service' is visible")
    public boolean divServiceIsDisplayed(){return divService.isDisplayed();}

    @Step("Checking if section 'Portfolio' is visible")
    public boolean sectionPortfolioIsDisplayed(){return sectionPortfolio.isDisplayed();}

    @Step("Checking if div 'Testimonial' is visible")
    public boolean divTestimonialIsDisplayed(){return divTestimonial.isDisplayed();}

    @Step("Checking if div 'Contact' is visible")
    public boolean divContactIsDisplayed(){return divContact.isDisplayed();}

    @Step("Checking if div 'Footer' is visible")
    public boolean divFooterIsDisplayed(){return divFooter.isDisplayed();}

    @Step("Checking if div 'Copyright' is visible")
    public boolean divCopyrightIsDisplayed(){return divCopyright.isDisplayed();}

    @Step("Fulfill form: Name")
    public void fulfillName(String name){inputFieldName.setValue(name);}

    @Step("Fulfill form: Email")
    public void fulfillEmail(String email){inputFieldEmail.setValue(email);}

    @Step("Fulfill form: Company")
    public void fulfillCompany(String company){inputFieldCompany.setValue(company);}

    @Step("Fulfill form: Message")
    public void fulfillMessage(String message){textAreaFieldMessage.setValue(message);}

    @Step("Check checkbox")
    public void checkingCheckbox(){
        executeJavaScript("arguments[0].style.display = 'unset';", checkBox);
        checkBox.click();}

    @Step("Click Submit button")
    public void clickSubmitButton(){submitButton.click();}

    @Step("Matching footer text (should be exactly: {texting)")
    public void assertFooterText(String texting){
        String tx = footerText.getText();
        assertEquals(tx, texting);
    }

    @Step("Taking screenshot of the beginning and the end of a page {scr_num}")
    public void takescreenshotF(int scr_num) {
        Allure.addAttachment("Scroll Screenshot" +
                scr_num, new ByteArrayInputStream(screenshot(OutputType.BYTES)));
    }

    @Step("Taking screenshot of form")
    public void takescreenshot() {
        Allure.addAttachment("Form Screenshot", new ByteArrayInputStream(screenshot(OutputType.BYTES)));
    }
}
