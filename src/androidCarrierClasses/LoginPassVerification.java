package androidCarrierClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;

public class LoginPassVerification {

	public LoginPassVerification() {
	}

	public void PassExpected() throws Exception {

//		Sleep appSleep = new Sleep();
		AndroidLogs androidLogs = new AndroidLogs();
//		Wait appWait = new Wait();
		AppStringsAndroid androidText = new AppStringsAndroid();
		RepoCarrierAndroid elements = new RepoCarrierAndroid();

		Thread.sleep(3000);
		WebElement cardSuccess = elements.LoginCarrierTextBox();
		if (cardSuccess.isDisplayed()) {
			cardSuccess.click();
			cardSuccess.clear();
			cardSuccess.click();
			Thread.sleep(3000);
			Actions actioncardSuccess = new Actions(Capabilities.driver);
			actioncardSuccess.sendKeys(androidText.CARRIER_LOGIN_PASSWORD_SUSPENDED).build().perform();
			androidLogs.CapturedLogs(androidText.PASS, "Card Number entered.");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "CardNumber text box is not found");
		}

		Thread.sleep(3000);
		// Find the login Password text box
		Thread.sleep(3000);
		WebElement pinSuccesfull = elements.LoginCarrierPasswordTextBox();
		if (pinSuccesfull.isDisplayed()) {
			pinSuccesfull.click();
			pinSuccesfull.clear();
			Thread.sleep(3000);
			pinSuccesfull.click();
			Actions actionpinSuccesfull = new Actions(Capabilities.driver);
			actionpinSuccesfull.sendKeys(androidText.getENVData("CARDPIN_LOGIN_PIN_6344")).build().perform(); // send Pin to card
			Thread.sleep(3000);
			androidLogs.CapturedLogs(androidText.PASS, "Pin entered.");

		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Pin text box is not found");
		}


		Thread.sleep(3000);
		WebElement loginKey = elements.LoginButtonCarrierControl();
		if (loginKey != null && loginKey.isEnabled()) {
			loginKey.click();
			androidLogs.CapturedLogs(androidText.PASS, "Login Button Pressed.");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Login Button is not found");
		}
		Thread.sleep(3000);


	}

}
