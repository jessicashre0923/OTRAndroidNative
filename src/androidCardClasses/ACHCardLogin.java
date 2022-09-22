package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;

//import io.appium.java_client.AppiumDriver;

public class ACHCardLogin {
	public ACHCardLogin() {
	}

private String env;
	
	public void CardPassExpected(String environment) throws Exception {
		this.env = environment;
		System.out.println("I am in ACH login Pass environment is:" + environment);
		CardPassExpected();
	}
		
	
	public void CardPassExpected() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();

		AndroidLogs.setupTest("Login Pass Expected Testing started 2800");
		AndroidLogs.CapturedLogs(androidText.INFO, "Login Pass Expected Testing started.");

		Thread.sleep(3000);

		WebElement ClearCardNumberTextBox = elements.ClearCardNumberTextBox();
		if (ClearCardNumberTextBox != null && ClearCardNumberTextBox.isDisplayed()) {
			ClearCardNumberTextBox.click();
			// TODO add select info button
			AndroidLogs.CapturedLogs(androidText.PASS, "Clear text box button selected.");
		} else {
			AndroidLogs.CapturedLogs(androidText.INFO, "Clear text box button not found");
		}

		Thread.sleep(3000);

		WebElement CardNumberTextBox = elements.CardNumberTextBox();
		if (CardNumberTextBox != null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			// TODO add select info button
			CardNumberTextBox.sendKeys(androidText.getENVData("CARD_ACH_LOGIN_2800"));
			AndroidLogs.CapturedLogs(androidText.PASS, "Card Number was entered.");
		} else {
			AndroidLogs.CapturedLogs(androidText.FAIL, "Card Number text box is not found");
		}

		Thread.sleep(3000);

		// Find the login Password text box tell if find or Test Fail.
		WebElement PinPassTextBox = elements.PinPassTextBox();

		if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.sendKeys(androidText.getENVData("CARD_ACH_2800_PIN"));
			Thread.sleep(3000);
			AndroidLogs.CapturedLogs(androidText.PASS, "Pin/passcode entered");
// TODO				add	select hide show password button

		} else {
			AndroidLogs.CapturedLogs(androidText.FAIL, "Pin/passcode was not found");
		}

// TODO				add	some options for Forgot Pin or passcode maybe go into and close. 

		WebElement CardLoginButton = elements.CardLoginButton();
		if (CardLoginButton != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			AndroidLogs.CapturedLogs(androidText.PASS, "Login Button Pressed.");
			Thread.sleep(3000);
		} else {
			AndroidLogs.CapturedLogs(androidText.FAIL, "Login Button was not found");
		}

	}

}
