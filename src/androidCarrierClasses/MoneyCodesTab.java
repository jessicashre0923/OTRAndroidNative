package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class MoneyCodesTab {

	AndroidLogs androidLogs = new AndroidLogs();
	ScrollOptions pull = new ScrollOptions();
	TextBoxXpaths appText = new TextBoxXpaths();
	CreateMoneyCodeBillMeLater newMoneyCode = new CreateMoneyCodeBillMeLater();
	CreateMoneyCodeDeductFeeNow newMoneyCodeDeductFee = new CreateMoneyCodeDeductFeeNow();
	RepoCarrierAndroid elements =new RepoCarrierAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ProgressSpinner loading = new ProgressSpinner();
	
	static AppiumDriver<WebElement> driver;
	
	public MoneyCodesTab moneyCodesTab() throws Exception {
		androidLogs.setupTest("Tests for MoneyCodes Tab");
		int touchCountDown = 0;
		int touchCountUp = 0;
				
		Thread.sleep(3000);
		WebElement MoneyCodesTab = elements.MoneyCodesTab();
		Thread.sleep(3000);
			if (MoneyCodesTab != null && MoneyCodesTab.isDisplayed()) {
				MoneyCodesTab.click();
				androidLogs.CapturedLogs(androidText.PASS, "MoneyCodes Tab is opened");
				loading.progressSpinnerLoadMoneyCodes();
				
				Thread.sleep(3000);
				WebElement MultiUseMoneyCodeSeen=elements.MultiUseMoneyCodeSeen();
				Thread.sleep(3000);
				if(MultiUseMoneyCodeSeen!=null && MultiUseMoneyCodeSeen.isDisplayed()) {
					androidLogs.CapturedLogs(androidText.PASS, "MultiUse Money code displayed");
				
				}else {
					androidLogs.CapturedLogs(androidText.INFO, "Multiuse Moneycode not found in list Contract may not have this option");
				}
				
				//Create a new moneycode bill me later.
				Thread.sleep(2000);
				newMoneyCode.createMoneyCode();
				
//Create a new moneycode Deduct fee.
				Thread.sleep(2000);
				newMoneyCodeDeductFee.createMoneyCode();

				
				//Click view all top button
				Thread.sleep(2000);
				WebElement ViewAllTopButton = elements.ViewAllTopButton();
				Thread.sleep(3000);
				if (ViewAllTopButton!=null && ViewAllTopButton.isEnabled()) {
					ViewAllTopButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "view All Button Top is opened");
					Thread.sleep(2000);
					
					while (touchCountDown < 5){
					pull.ScrollDown();
					touchCountDown ++;
					}
					
					while (touchCountUp <5) {
						pull.ScrollUp();
						touchCountUp ++;
					}
				}else {
					androidLogs.CapturedLogs(androidText.FAIL,"View all button top not found");
				}
				
				Thread.sleep(3000);
				WebElement MoneyCodeActivityBackButton = elements.MoneyCodeActivityBackButton();
				Thread.sleep(3000);
				if (MoneyCodeActivityBackButton.isDisplayed()) {
					Thread.sleep(3000);
					MoneyCodeActivityBackButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "Money Code Activity Back button is opened");
					Thread.sleep(3000);
			}
				else {
					androidLogs.CapturedLogs(androidText.FAIL, "Money Code Activity Back button not found");
				}
				
				pull.ScrollDown();
				pull.ScrollDown();
				pull.ScrollDown();
				
				Thread.sleep(3000);
				WebElement ViewAllBottomButton=elements.ViewAllBottomButton();
				Thread.sleep(3000);
				if(ViewAllBottomButton!=null && ViewAllBottomButton.isEnabled()) {
					ViewAllBottomButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "view All Button bottom is opened");
					Thread.sleep(3000);
					elements.MoneyCodeActivityBackButton().click();
					androidLogs.CapturedLogs(androidText.PASS, "Back button selected");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "View all bottom button not found");
				}

			}
			else {
				androidLogs.CapturedLogs(androidText.FAIL, "MoneyCodes Tab not found");
			}
		return this;
	}
}
