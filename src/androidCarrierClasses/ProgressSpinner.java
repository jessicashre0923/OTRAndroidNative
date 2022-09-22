package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class ProgressSpinner {

	AndroidLogs androidLogs = new AndroidLogs();
	ScrollOptions pull = new ScrollOptions();
	TextBoxXpaths appText = new TextBoxXpaths();
	CreateMoneyCodeBillMeLater newMoneyCode = new CreateMoneyCodeBillMeLater();
	CreateMoneyCodeDeductFeeNow newMoneyCodeDeductFee = new CreateMoneyCodeDeductFeeNow();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();

	static AppiumDriver<WebElement> driver;

	public ProgressSpinner progressSpinnerSubmitPaymentInvoice() throws Exception {
		// check progress spinner
		Thread.sleep(2000);
		WebElement progressSpinnerSubmitPaymentInvoice = elements.progressSpinnerSubmitPaymentInvoice();
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
		while (progressSpinnerSubmitPaymentInvoice != null && progressSpinnerSubmitPaymentInvoice.isDisplayed()) {
			// androidLogs.CapturedLogs(androidText.INFO, "Progress spinnnerSubmit Payment
			// on invoice seen waiting 3000");
			Thread.sleep(3000);
			progressSpinnerSubmitPaymentInvoice = elements.progressSpinnerSubmitPaymentInvoice();
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
		return this;
	}
		
	public ProgressSpinner progressSpinnerWaitForTransactions() throws Exception {
		// check progress spinner
		Thread.sleep(2000);
		WebElement progressSpinnerWaitForTransactionsViewAll = elements.LoadingTransactionSpinnerText();
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
		while (progressSpinnerWaitForTransactionsViewAll != null && progressSpinnerWaitForTransactionsViewAll.isDisplayed()) {
			// androidLogs.CapturedLogs(androidText.INFO, "Progress spinnnerSubmit Payment
			// on invoice seen waiting 3000");
			Thread.sleep(3000);
			progressSpinnerWaitForTransactionsViewAll = elements.LoadingTransactionSpinnerText();
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
		return this;
	}
	
	
	public ProgressSpinner LoadingTransactionViewallSpinnerText() throws Exception {
		// check progress spinner
		Thread.sleep(2000);
		WebElement LoadingTransactionViewallSpinnerText = elements.LoadingTransactionViewallSpinnerText();
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
		while (LoadingTransactionViewallSpinnerText != null && LoadingTransactionViewallSpinnerText.isDisplayed()) {
			// androidLogs.CapturedLogs(androidText.INFO, "Progress spinnnerSubmit Payment
			// on invoice seen waiting 3000");
			Thread.sleep(3000);
		
			
			LoadingTransactionViewallSpinnerText = elements.LoadingTransactionViewallSpinnerText();
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
		return this;
	}
	
	
	

	

	public ProgressSpinner progressSpinnerLoadMoneyCodes() throws Exception {
		Thread.sleep(2000);
		WebElement progressSpinnerLoadMoneyCodes = elements.progressSpinnerLoadMoneyCodes();
		// check progress spinner
		Thread.sleep(2000);
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
		
		while (progressSpinnerLoadMoneyCodes != null
				&& progressSpinnerLoadMoneyCodes.isDisplayed()) {
			Thread.sleep(3000);
			progressSpinnerLoadMoneyCodes = elements.progressSpinnerLoadMoneyCodes();
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
		return this;
	}
	
	
	public ProgressSpinner progressSpinnerSaveEmail() throws Exception {
		Thread.sleep(2000);
		WebElement progressSpinnerSaveEmail = elements.progressSpinnerSaveEmail();
		// check progress spinner
		Thread.sleep(2000);
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
		
		while (progressSpinnerSaveEmail != null
				&& progressSpinnerSaveEmail.isDisplayed()) {
			Thread.sleep(3000);
			progressSpinnerSaveEmail = elements.progressSpinnerSaveEmail();
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
		return this;
	}
	
	
	public ProgressSpinner LoginSpinnerCardControl() throws Exception {
		// check progress spinner
		Thread.sleep(2000);
		WebElement progressSpinnerWaitForTransactionsViewAll = elements.LoadingTransactionSpinnerText();
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner checker started");
		while (progressSpinnerWaitForTransactionsViewAll != null && progressSpinnerWaitForTransactionsViewAll.isDisplayed()) {
			// androidLogs.CapturedLogs(androidText.INFO, "Progress spinnnerSubmit Payment
			// on invoice seen waiting 3000");
			Thread.sleep(3000);
			progressSpinnerWaitForTransactionsViewAll = elements.LoadingTransactionSpinnerText();
		}
		androidLogs.CapturedLogs(androidText.INFO, "Loading spinner on page checker completed");
		return this;
	}
	

	// TODO use this style if unable to use a text to find xpath.
//		Thread.sleep(2000);
//		while (elements.progressSpinnerSubmitPaymentInvoice()!= null && elements.progressSpinnerSubmitPaymentInvoice().isDisplayed()) {
//			androidLogs.CapturedLogs(androidText.INFO, "Progress spinnnerSubmit Payment on invoice seen waiting 3000");
//			Thread.sleep(3000);
//		}
//		return this;
//	}

}
