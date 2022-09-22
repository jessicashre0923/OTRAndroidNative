package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class PayInvoiceBilling {
	AndroidLogs androidLogs = new AndroidLogs();
	ScrollOptions pull = new ScrollOptions();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	ProgressSpinner loading = new ProgressSpinner();


//	Wait appWait = new Wait();
	AppStringsAndroid androidText = new AppStringsAndroid();
	static AppiumDriver<WebElement> driver;
	// static WebDriver driverWeb;

	public PayInvoiceBilling payInvoice() throws Exception {
		androidLogs.setupTest("Tests for Pay Invoice in Billing Tab");
		
		Thread.sleep(5000);
		pull.ScrollDown();
		pull.ScrollDown();
		
		Thread.sleep(2000);
		WebElement SelectAR = elements.SelectAR();
		Thread.sleep(2000);
		if (SelectAR != null && SelectAR.isEnabled()) {
			SelectAR.click();
			androidLogs.CapturedLogs(androidText.PASS, "AR selected.");
			Thread.sleep(2000);
			elements.PayNowButton().click();
			Thread.sleep(2000);
			androidLogs.CapturedLogs(androidText.PASS, "Pay now button selected.");
			// elements.SelectInvoice().click(); //it is selected by default when page opens
			elements.SelectNextButton().click();
			Thread.sleep(2000);
			androidLogs.CapturedLogs(androidText.PASS, "Next button selected.");
			
			Thread.sleep(2000);	
			WebElement SelectBankAccount = elements.SelectBankAccount();
			Thread.sleep(2000);	
			if (SelectBankAccount != null && SelectBankAccount.isEnabled()) {
				SelectBankAccount.click();
				androidLogs.CapturedLogs(androidText.PASS, "Bank account selected.");
				elements.SelectNextButton().click();
				androidLogs.CapturedLogs(androidText.PASS, "Next button selected.");
			}else {
				androidLogs.CapturedLogs(androidText.INFO, "Bank account not found");
			}
			
			elements.EditPaymentAmountButton().click();
			androidLogs.CapturedLogs(androidText.PASS, "Edit Payment Amount button clicked.");
			
			Thread.sleep(2000);	
			elements.PaymentAmountTextBox().sendKeys("9.00");
			androidLogs.CapturedLogs(androidText.PASS, "Payment amount entered.");
			
			Thread.sleep(2000);	
			elements.SaveButton().click();
			androidLogs.CapturedLogs(androidText.PASS, "Save button selected");

			Thread.sleep(2000);	
			elements.SchedulePaymentButton().click();
			androidLogs.CapturedLogs(androidText.PASS, "Schedule payment button clicked.");
			
			
//check progress spinner			
			loading.progressSpinnerSubmitPaymentInvoice();
			
			
			Thread.sleep(3000);
			WebElement paymentCouldNotBeScheduled = elements.RequestTimeOutOKButton();
			Thread.sleep(2000);	
			if (paymentCouldNotBeScheduled != null && paymentCouldNotBeScheduled.isEnabled()) {
				paymentCouldNotBeScheduled.click();
				androidLogs.CapturedLogs(androidText.PASS, "Schedule payment error Payement could not be seen OK button clicked");
				WebElement closeTransferError = elements.TransferToYourBankCloseButton();
				Thread.sleep(2000);	
				closeTransferError.click();
				androidLogs.CapturedLogs(androidText.PASS, "Close used to close transfer funds due to error");
				WebElement BillingExitButton = elements.BillingExitButton();
				Thread.sleep(2000);	
				BillingExitButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Exit Billing button clicked");
			} else {
				androidLogs.CapturedLogs(androidText.INFO, "Payment could not be Scheduled modal was not found as expected");
			}
			
			
		Thread.sleep(3000);
			WebElement DoneButton = elements.DoneButton();
			Thread.sleep(2000);	
			if (DoneButton != null && DoneButton.isEnabled()) {
				DoneButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Done button clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Done button not seen.");
			}
			
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "AR not found");
		}
		return this;
	}

}
