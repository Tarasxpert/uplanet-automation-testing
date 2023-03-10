package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ui.base.BrowserStackDriver;
import ui.pages.CloudcampaignCRMDashboardPage;
import ui.pages.CloudcampaignCRMLoginPage;

import static org.testng.Assert.assertEquals;

public class PostingImmediatelyToTwitterTest extends BrowserStackDriver {
    @Test(description= "")
    @Owner("Taras Zelenskyi")
    @Description("")
    public void loginTest() throws InterruptedException {
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        CloudcampaignCRMDashboardPage cloudcampaignCRMDashboardPage = new CloudcampaignCRMDashboardPage();
        cloudcampaignCRMLoginPage.login();
        cloudcampaignCRMDashboardPage.clickPostNowButton();
        cloudcampaignCRMDashboardPage.inputTextAreaInPostNow("dogs");
        cloudcampaignCRMDashboardPage.clickToTwitterInChooseAccounts();
        cloudcampaignCRMDashboardPage.clickToPublishButton();
        Thread.sleep(15000);
        assertEquals(cloudcampaignCRMDashboardPage.getTextFromSuccessTextAfterPublish(),
                "Your post was just published to social media.");
    }
}
