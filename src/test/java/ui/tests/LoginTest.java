package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ui.base.SelenideBaseDriver;
import ui.pages.CloudcampaignCRMDashboardPage;
import ui.pages.CloudcampaignCRMLoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends SelenideBaseDriver {
    @Test(description= "Login test in https://app.qa.cloudcampaign.com")
    @Owner("Taras Zelenskyi")
    @Description("Logging in to CRM using existing credentials and checking if dashboard is displayed and visible.")
    public void loginTest() {
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.login();
        CloudcampaignCRMDashboardPage cloudcampaignCRMDashboardPage = new CloudcampaignCRMDashboardPage();
        assertTrue(cloudcampaignCRMDashboardPage.isDisplayedDashboardButton());
    }
}
