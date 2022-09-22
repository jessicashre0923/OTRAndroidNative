package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;

public class CardLoginPassSecureFuel {
//	public CardLoginPassSecureFuel() {
//	}

	private String env;
	private String cardNum;
	private String passwordOrPin;
	
	public void CardPassExpected(String environment, String cardNumber, String passwordOrPin) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		CardPassExpected();
	}
	
	
	public void CardPassExpected() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;	
		
		
		
		
		AndroidLogs.setupTest("Login Pass Expected Testing started 0561");
		AndroidLogs.CapturedLogs(info, "Login Pass Expected Testing started.");

		Thread.sleep(3000);

		
		
		WebElement CardNumberTextBox = elements.CardNumberTextBox();
		if (CardNumberTextBox != null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			// TODO add select info button
//old			CardNumberTextBox.sendKeys(androidText.CARD_LOGIN_LOCK_EXPECTED);
			CardNumberTextBox.sendKeys(cardNum);


			AndroidLogs.CapturedLogs(pass, "Card Number was entered.");
		} else {
			AndroidLogs.CapturedLogs(fail, "Card Number text box is not found");
		}

		Thread.sleep(3000);

		// Find the login Password text box tell if find or Test Fail.
		WebElement PinPassTextBox = elements.PinPassTextBox();

		if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.sendKeys(passwordOrPin);
			AndroidLogs.CapturedLogs(pass, "Pin/passcode entered");
			Thread.sleep(3000);

//TODO				add	select hide show password button

		} else {
			AndroidLogs.CapturedLogs(fail, "Pin/passcode was not found");
		}

//TODO				add	some options for Forgot Pin or passcode maybe go into and close. 

		WebElement CardLoginButton = elements.CardLoginButton();
		if (CardLoginButton != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			AndroidLogs.CapturedLogs(pass, "Login Button Pressed.");
			Thread.sleep(3000);
		} else {
			AndroidLogs.CapturedLogs(fail, "Login Button was not found");
		}
	}

}
