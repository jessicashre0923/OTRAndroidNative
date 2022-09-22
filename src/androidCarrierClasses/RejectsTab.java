package androidCarrierClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class RejectsTab {

	AndroidLogs androidLogs = new AndroidLogs();
	ScrollOptions pull = new ScrollOptions();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ProgressSpinner loading = new ProgressSpinner();
	static AppiumDriver<WebElement> driver;

@Test
	public RejectsTab rejectsTab() throws Exception {
		androidLogs.setupTest("Testing on transaction tab");
		Thread.sleep(3000);
		// Find and click the Transactions Tab and tap it to open transactions section.
		
		Thread.sleep(3000);
		WebElement RejectsTab = elements.RejectsTab();
		Thread.sleep(3000);
		if (RejectsTab != null && RejectsTab.isEnabled()) {
			RejectsTab.click();
			androidLogs.CapturedLogs(androidText.PASS, "RejectsTab tab opened");
			Thread.sleep(3000);
		//	pull.Refresh();
			
			
		
			loading.progressSpinnerWaitForTransactions();

			
			Thread.sleep(3000);
			WebElement RequestTimeOutOKButton = elements.RequestTimeOutOKButton();
			Thread.sleep(3000);
			if (RequestTimeOutOKButton != null && RequestTimeOutOKButton.isEnabled()) {
				RequestTimeOutOKButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Request timed out OK button clicked");

			} else if (elements.WaitForTransactionLoad().isEnabled()) {
				androidLogs.CapturedLogs(androidText.PASS, "Wait for transaction to load completed");
				
				Thread.sleep(3000);
				WebElement ViewAllTopButtonTrans=elements.ViewAllTopButtonTrans();
				Thread.sleep(3000);
				if (ViewAllTopButtonTrans != null && ViewAllTopButtonTrans.isEnabled()) {
					ViewAllTopButtonTrans.click();
					androidLogs.CapturedLogs(androidText.PASS, "View all top button clicked");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "View all top button not found");
				}
//				if(elements.WaitForTransactionLoad().isEnabled()) {
//				logs.CapturedLogs("Test Pass", "Wait for transaction to load completed");
//				
//				if(elements.ViewAllTopButtonTrans()!=null && elements.ViewAllTopButtonTrans().isEnabled()) {
//					elements.ViewAllTopButtonTrans().click();
//				}
//					
				Thread.sleep(3000);
				pull.Refresh();
				loading.LoadingTransactionViewallSpinnerText();
				
				Thread.sleep(3000);
				WebElement NoActivityYetText=elements.NoActivityYetText();
				Thread.sleep(3000);
				if (NoActivityYetText != null && NoActivityYetText.isEnabled()) {
					androidLogs.CapturedLogs(androidText.INFO, "Reject History not loading");
				} else if (elements.WaitForRejectHistoryLoad().isEnabled()) {
					androidLogs.CapturedLogs(androidText.INFO, "Reject History loaded");
					elements.WaitForRejectHistoryLoad().click();
					androidLogs.CapturedLogs(androidText.PASS, "Rejected transaction opened");
					

					
					// go into cards details here
					Thread.sleep(3000);
					pull.ScrollDown();
					Thread.sleep(3000);
					WebElement CardDetailsButton=elements.CardDetailsButton();
					Thread.sleep(3000);
					if(CardDetailsButton!=null && CardDetailsButton.isEnabled()) {
						CardDetailsButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Card details opened");
						Thread.sleep(5000);
						elements.CardDetailsBackButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Card details back button clicked");
					}else {
						androidLogs.CapturedLogs(androidText.FAIL, "Card details page not opened");
					}
					
					Thread.sleep(3000);
					WebElement RejectDetailsBackButton=elements.RejectDetailsBackButton();
					Thread.sleep(3000);
					if (RejectDetailsBackButton.isEnabled()) {
						RejectDetailsBackButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Reject details back button clicked");
						Thread.sleep(3000);

						pull.ScrollDown();
						pull.ScrollDown();
						pull.ScrollUp();
						pull.ScrollUp();
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Reject details back button not found");
					}
					
					Thread.sleep(3000);
					WebElement RejectHistoryBackButton=elements.RejectHistoryBackButton();
					Thread.sleep(3000);
					if (RejectHistoryBackButton.isEnabled()) {
						RejectHistoryBackButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Reject history back button clicked");

					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "reject Details back button not found");
					}
					Thread.sleep(3000);
					pull.ScrollDown();
					pull.ScrollDown();

					Thread.sleep(3000);
					WebElement ViewAllBottomButtonTrans=elements.ViewAllBottomButtonTrans();
					Thread.sleep(3000);
					if (ViewAllBottomButtonTrans != null
							&& ViewAllBottomButtonTrans.isEnabled()) {
						ViewAllBottomButtonTrans.click();
						androidLogs.CapturedLogs(androidText.PASS, "View all bottom button clicked");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "View all bottom button not found");
					}
					
					Thread.sleep(3000);
					WebElement RejectHistoryBackButton2=elements.RejectHistoryBackButton();
					Thread.sleep(3000);
					if (RejectHistoryBackButton2.isEnabled()) {
						RejectHistoryBackButton2.click();
						androidLogs.CapturedLogs(androidText.PASS, "Reject history back button clicked.");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "reject history back button not found");
					}

				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "reject history load incomplete");
				}
			}

		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Transaction tab not found");
		}
		return this;
	}
}