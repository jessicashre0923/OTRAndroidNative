package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class RepeatWeeklyTransferFunds {
	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements=new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new  AppStringsAndroid();
	
	public RepeatWeeklyTransferFunds RepeatWeeklyTransferFunds() throws Exception {;
		androidLogs.setupTest("Repeat transfer funds test");
		
		Thread.sleep(3000);
		WebElement TransferFundsButton = elements.TransferFundsButton();
		//Thread.sleep(3000);
		if (TransferFundsButton != null && TransferFundsButton.isEnabled()) {
			TransferFundsButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Transfer funds button clicked");
		} else {
			androidLogs.CapturedLogs(androidText.INFO, "Transfer funds button not found or unavailable in this card type");
		}
	
		Thread.sleep(3000);
		WebElement RepeatTransferRadioButton = elements.RepeatTransferRadioButton();
		//Thread.sleep(3000);
		if (RepeatTransferRadioButton != null && RepeatTransferRadioButton.isEnabled()) {
			RepeatTransferRadioButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Repeat transfer radio button clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Repeat transfer radio button not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButton = elements.NextTransferFundsButton();
		//Thread.sleep(3000);
		if (NextTransferFundsButton != null && NextTransferFundsButton.isEnabled()) {
			NextTransferFundsButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Next button Transfer type screen clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button Transfer type screeb not found");
		}
		
		Thread.sleep(3000);
		WebElement SelectBankAccount = elements.SelectBankAccount();
		//Thread.sleep(3000);
		if (SelectBankAccount != null && SelectBankAccount.isEnabled()) {
			SelectBankAccount.click();
			androidLogs.CapturedLogs(androidText.PASS, "Bank account selected");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Bank account not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButtonTransferTo = elements.NextTransferFundsButton();
		//Thread.sleep(3000);
		if (NextTransferFundsButtonTransferTo != null && NextTransferFundsButtonTransferTo.isEnabled()) {
			NextTransferFundsButtonTransferTo.click();
			androidLogs.CapturedLogs(androidText.PASS, "Next button transfer to screen clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button transfer to screen not found");
		}
		
		Thread.sleep(3000);
		WebElement PercentOfBalanceTab = elements.PercentOfBalanceTab();
		//Thread.sleep(3000);
		if (PercentOfBalanceTab != null && PercentOfBalanceTab.isEnabled()) {
			PercentOfBalanceTab.click();
			androidLogs.CapturedLogs(androidText.PASS, "% of balance clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "% of balance not found");
		}
		
		Thread.sleep(3000);
		WebElement EnterPercentTextBox = elements.EnterPercentTextBox();
		//Thread.sleep(3000);
		if (EnterPercentTextBox != null && EnterPercentTextBox.isEnabled()) {
			EnterPercentTextBox.sendKeys(androidText.POLICYSEARCH);
			androidLogs.CapturedLogs(androidText.PASS, "Percent entered");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Percent textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButtonEnterAmount = elements.NextTransferFundsButton();
		//Thread.sleep(3000);
		if (NextTransferFundsButtonEnterAmount != null && NextTransferFundsButtonEnterAmount.isEnabled()) {
			NextTransferFundsButtonEnterAmount.click();
			androidLogs.CapturedLogs(androidText.PASS, "Next button enter amount screen clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button enter amount screen not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsStartDate = elements.NextTransferFundsButton();
		//Thread.sleep(3000);
		if (NextTransferFundsStartDate != null && NextTransferFundsStartDate.isEnabled()) {
			NextTransferFundsStartDate.click();
			androidLogs.CapturedLogs(androidText.PASS, "Next button start date screen clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button start date screen not found");
		}
		
		Thread.sleep(3000);
		WebElement WeeklyRepeatSchedule = elements.WeeklyRepeatSchedule();
		//Thread.sleep(3000);
		if (WeeklyRepeatSchedule != null && WeeklyRepeatSchedule.isEnabled()) {
			WeeklyRepeatSchedule.click();
			androidLogs.CapturedLogs(androidText.PASS, "Weekly Repeat schedule clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Weekly Repeat schedule not found");
		}
		
		Thread.sleep(3000);
		WebElement NextButtonRepeatScheduleScreen = elements.NextTransferFundsButton();
		//Thread.sleep(3000);
		if (NextButtonRepeatScheduleScreen != null && NextButtonRepeatScheduleScreen.isEnabled()) {
			NextButtonRepeatScheduleScreen.click();
			androidLogs.CapturedLogs(androidText.PASS, "Next button repeat schedule screen clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button repeat schedule screen not found");
		}
		
		Thread.sleep(3000);
		WebElement SaturdayWeekly = elements.SaturdayWeekly();
		//Thread.sleep(3000);
		if (SaturdayWeekly != null && SaturdayWeekly.isEnabled()) {
			SaturdayWeekly.click();
			androidLogs.CapturedLogs(androidText.PASS, "Saturday clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Saturday not found");
		}
		
		Thread.sleep(3000);
		WebElement NextButtonDaysScreen = elements.NextTransferFundsButton();
		//Thread.sleep(3000);
		if (NextButtonDaysScreen != null && NextButtonDaysScreen.isEnabled()) {
			NextButtonDaysScreen.click();
			androidLogs.CapturedLogs(androidText.PASS, "Next button days screen clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button days screen not found");
		}
		
		Thread.sleep(3000);
		WebElement SetEndDateSwitch = elements.SetEndDateSwitch();
		//Thread.sleep(3000);
		if (SetEndDateSwitch != null && SetEndDateSwitch.isEnabled()) {
			SetEndDateSwitch.click();
			androidLogs.CapturedLogs(androidText.PASS, "End date switch clicked and turned on");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "End date switch not found");
		}
		
		Thread.sleep(3000);
		WebElement NextEndDateScreen = elements.NextTransferFundsButton();
		//Thread.sleep(3000);
		if (NextEndDateScreen != null && NextEndDateScreen.isEnabled()) {
			NextEndDateScreen.click();
			androidLogs.CapturedLogs(androidText.PASS, "Next button end date screen clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button end date screen not found");
		}
		
		Thread.sleep(3000);
		WebElement SubmitButton = elements.SubmitButton();
		//Thread.sleep(3000);
		if (SubmitButton != null && SubmitButton.isEnabled()) {
			SubmitButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Submit button clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Submit button not found");
		}
		
		Thread.sleep(6000);
		WebElement DismissButtonTransferFunds = elements.DismissButtonTransferFunds();
		//Thread.sleep(3000);
		if (DismissButtonTransferFunds != null && DismissButtonTransferFunds.isEnabled()) {
			DismissButtonTransferFunds.click();
			androidLogs.CapturedLogs(androidText.PASS, "Dismiss button clicked");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Dismiss button not found");
		}
		//Thread.sleep(3000);
		return this;
	}
}
