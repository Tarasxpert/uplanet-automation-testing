package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ui.base.BrowserStackDriver;
import ui.pages.CloudcampaignCRMDashboardPage;
import ui.pages.CloudcampaignCRMLoginPage;
import utils.DataGenerator;

import static org.testng.Assert.assertEquals;

public class PostingImmediatelyToTwitterTest extends BrowserStackDriver {
    @Test(description= "Posting immediately to twitter test")
    @Owner("Taras Zelenskyi")
    @Description("'Posting Now' to Twitter is available.")
    public void postingImmediatelyToTwitterTest() {
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        CloudcampaignCRMDashboardPage cloudcampaignCRMDashboardPage = new CloudcampaignCRMDashboardPage();
        cloudcampaignCRMLoginPage.login();
        cloudcampaignCRMDashboardPage.clickPostNowButton();
        cloudcampaignCRMDashboardPage.inputTextAreaInPostNow(DataGenerator.generateString(10));
        cloudcampaignCRMDashboardPage.clickToTwitterInChooseAccounts();
        cloudcampaignCRMDashboardPage.clickToPublishButton();
        assertEquals(cloudcampaignCRMDashboardPage.getTextFromSuccessTextAfterPublish(),
                "Your post was just published to social media.");
    }
}
