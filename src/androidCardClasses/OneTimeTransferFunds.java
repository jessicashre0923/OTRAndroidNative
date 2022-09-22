package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class OneTimeTransferFunds {
	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements=new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new  AppStringsAndroid();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
	public OneTimeTransferFunds OneTimeTransferFunds() throws Exception {
		androidLogs.setupTest("One Time transfer funds test");
		
		
		
		Thread.sleep(3000);
		WebElement TransferFundsButton = elements.TransferFundsButton();
		if (TransferFundsButton != null && TransferFundsButton.isEnabled()) {
			TransferFundsButton.click();
			androidLogs.CapturedLogs(pass, "Transfer funds button clicked");
		} else {
			androidLogs.CapturedLogs(info, "Transfer funds button not found or unavailable in this card type");
		}
	
		Thread.sleep(2000);
		WebElement OneTimeTransferRadioButton = elements.OneTimeTransferRadioButton();
		if (OneTimeTransferRadioButton != null && OneTimeTransferRadioButton.isEnabled()) {
			OneTimeTransferRadioButton.click();
			androidLogs.CapturedLogs(pass, "One time transfer radio button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "One time transfer radio button not found");
		}
		
		Thread.sleep(2000);
		WebElement NextTransferFundsButton = elements.NextTransferFundsButton();
		if (NextTransferFundsButton != null && NextTransferFundsButton.isEnabled()) {
			NextTransferFundsButton.click();
			androidLogs.CapturedLogs(pass, "Next button Transfer type screen clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next button Transfer type screeb not found");
		}
		
		Thread.sleep(3000);
		WebElement SelectBankAccount = elements.SelectBankAccount();
		if (SelectBankAccount != null && SelectBankAccount.isEnabled()) {
			SelectBankAccount.click();
			androidLogs.CapturedLogs(pass, "Bank account selected");
		} else {
			androidLogs.CapturedLogs(fail, "Bank account not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButtonTransferTo = elements.NextTransferFundsButton();
		if (NextTransferFundsButtonTransferTo != null && NextTransferFundsButtonTransferTo.isEnabled()) {
			NextTransferFundsButtonTransferTo.click();
			androidLogs.CapturedLogs(pass, "Next button transfer to screen clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next button transfer to screen not found");
		}
		
		Thread.sleep(3000);
		WebElement EnterAmountTextBox = elements.EnterAmountTextBox();
		if (EnterAmountTextBox != null && EnterAmountTextBox.isEnabled()) {
			EnterAmountTextBox.sendKeys(androidText.TRANSFER_FUNDS_AMOUNT);
			androidLogs.CapturedLogs(pass, "Transfer Funds amount entered as: " + androidText.TRANSFER_FUNDS_AMOUNT);
		} else {
			androidLogs.CapturedLogs(fail, "Amount textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButtonEnterAmount = elements.NextTransferFundsButton();
		if (NextTransferFundsButtonEnterAmount != null && NextTransferFundsButtonEnterAmount.isEnabled()) {
			NextTransferFundsButtonEnterAmount.click();
			androidLogs.CapturedLogs(pass, "Next button enter amount screen clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next button enter amount screen not found");
		}
		
		
		Thread.sleep(3000);
		WebElement SubmitButton = elements.SubmitButton();
		if (SubmitButton != null && SubmitButton.isEnabled()) {
			SubmitButton.click();
			androidLogs.CapturedLogs(pass, "Submit button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Submit button not found");
		}
		
		Thread.sleep(6000);
		WebElement DismissButtonTransferFunds = elements.DismissButtonTransferFunds();
		if (DismissButtonTransferFunds != null && DismissButtonTransferFunds.isEnabled()) {
			DismissButtonTransferFunds.click();
			androidLogs.CapturedLogs(pass, "Dismiss button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Dismiss button not found");
		}
		Thread.sleep(3000);
		return this;
	}
}
